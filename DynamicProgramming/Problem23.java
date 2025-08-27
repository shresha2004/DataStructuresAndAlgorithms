//Problem:https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
class Solution {

     static int knapSackRecursive(int val[], int wt[], int capacity) {
        // code here
        return knapSackRecursive(val,wt,capacity,0);
        
    }
    private static int knapSackRecursive(int val[],int wt[],int capacity,int index){
        if(index == wt.length) return 0;
        int notPick = knapSackRecursive(val,wt,capacity,index+1);
        int pick = 0;
        if(wt[index]<= capacity) pick = val[index]+knapSackRecursive(val,wt,capacity-wt[index],index);
        return Math.max(pick,notPick);
    }


    static int knapSackMemo(int val[], int wt[], int capacity) {
        // code here
        int[][] memo = new int[wt.length][capacity+1];
        for(int i=0;i<wt.length;i++)
            for(int j=0;j<capacity+1;j++)
                memo[i][j]= -1;
        return knapSackMemo(val,wt,capacity,0,memo);
        
    }
    private static int knapSackMemo(int val[],int wt[],int capacity,int index,int[][] memo){
        if(index == wt.length) return 0;
        if(memo[index][capacity]!= -1) return memo[index][capacity];
        int notPick = knapSackMemo(val,wt,capacity,index+1,memo);
        int pick = 0;
        if(wt[index]<= capacity) pick = val[index]+knapSackMemo(val,wt,capacity-wt[index],index,memo);
        return memo[index][capacity]=Math.max(pick,notPick);
    }

     static int knapSackTabu(int val[], int wt[], int capacity) {
        // code here
        int[][] tabu = new int[wt.length][capacity+1];
        for(int c=0;c<=capacity;c++){
            // c/wt[0] determines how many wt can u fill for that capacity. * val[0] determines value
            tabu[0][c]= ((int)c/wt[0] *(val[0]));
        }
        for(int i=1;i<wt.length;i++){
            for(int c=0;c<=capacity;c++){
                int notPick = tabu[i-1][c];
                int pick = 0;
              if(wt[i]<= c)   pick = val[i]+tabu[i][c-wt[i]];
              tabu[i][c]= Math.max(pick,notPick);
            }
        }
        return tabu[wt.length-1][capacity];
        
    }

     static int knapSackSpo(int val[], int wt[], int capacity) {
        // code here
        int[] spo = new int[capacity+1];
        for(int c=0;c<=capacity;c++){
            // c/wt[0] determines how many wt can u fill for that capacity. * val[0] determines value
            spo[c]= ((int)c/wt[0] *(val[0]));
        }
        for(int i=1;i<wt.length;i++){
            int[] temp = new int[capacity+1];
            for(int c=0;c<=capacity;c++){
                int notPick = spo[c];
                int pick = 0;
              if(wt[i]<= c)   pick = val[i]+temp[c-wt[i]];
              temp[c]= Math.max(pick,notPick);
            }
            spo= temp;
        }
        return spo[capacity];
        
    }
   
}
public class Problem23 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] val = {1, 1}, wt = {2, 1};
       int capacity = 3;
       System.out.println("Recursive:"+s.knapSackRecursive(val, wt, capacity));
       System.out.println("Memoization:"+s.knapSackMemo(val, wt, capacity));
       System.out.println("Tabulation:"+s.knapSackTabu(val, wt, capacity));
       System.out.println("Space Optimization:"+s.knapSackSpo(val, wt, capacity));
    }
}
