//Problem:https://www.geeksforgeeks.org/problems/rod-cutting0840/1
class Solution {
    public int cutRodRecursive(int[] price) {
        // code here
        return maxRodRecursive(price,0,price.length);
        
    }
    private int maxRodRecursive(int[] price,int index,int N){
        if(index == price.length) return 0;
        int notPick=0+maxRodRecursive(price,index+1,N);
        int pick = 0;
        int rodPiece = index+1;
        if(rodPiece <= (N))
            pick = price[index]+maxRodRecursive(price,index,N-rodPiece);
            
        return Math.max(pick,notPick);
    }

     public int cutRodMemo(int[] price) {
        // code here
        int N = price.length;
        int[][] memo = new int[N][N+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=N;j++){
                memo[i][j]= -1;
            }
        }
        return maxRodMemo(price,0,N,memo);
    }
    
    private int maxRodMemo(int[] price,int index,int N,int[][] memo){
        if(index == price.length) return 0;
        if(memo[index][N] != -1) return memo[index][N];
        int notPick=0+maxRodMemo(price,index+1,N,memo);
        int pick = 0;
        int rodPiece = index+1;
        if(rodPiece <= (N))
            pick = price[index]+maxRodMemo(price,index,N-rodPiece,memo);
            
        return memo[index][N]=Math.max(pick,notPick);
    }

     public int cutRodTabu(int[] price) {
        // code here
        int N = price.length;
        int[][] tabu = new int[N][N+1];
        for(int i=0;i<=N;i++)
            tabu[0][i]=i*price[0];
            
        for(int i=1;i<N;i++){
            for(int j=0;j<=N;j++){
                int notPick =0+ tabu[i-1][j];
                int pick =Integer.MIN_VALUE;
                int rodLen = i+1;
                if(rodLen <= j) 
                    pick = price[i]+tabu[i][j-rodLen];
                tabu[i][j]= Math.max(pick,notPick);
            }
        }
        return tabu[N-1][N];
    }

      public int cutRodSpo(int[] price) {
        // code here
        int N = price.length;
        int[] spo = new int[N+1];
        for(int i=0;i<=N;i++)
            spo[i]=i*price[0];
            
        for(int i=1;i<N;i++){
            int[] temp = new int[N+1];
            for(int j=0;j<=N;j++){
                int notPick =0+ spo[j];
                int pick =Integer.MIN_VALUE;
                int rodLen = i+1;
                if(rodLen <= j) 
                    pick = price[i]+temp[j-rodLen];
                temp[j]= Math.max(pick,notPick);
            }
            spo = temp;
        }
        return spo[N];
    }
}
public class Problem24 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int[]  price= {1, 5, 8, 9, 10, 17, 17, 20};
      System.out.println("Recursive:"+s.cutRodRecursive(price));
      System.out.println("Memoization:"+s.cutRodMemo(price));
      System.out.println("Tabulation:"+s.cutRodTabu(price));
      System.out.println("Space Optimization:"+s.cutRodSpo(price));
    }
}
