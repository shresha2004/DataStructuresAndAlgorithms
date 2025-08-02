class Solution {
    public int frogJumpRecursive(int[] heights, int k) {
        int n = heights.length;
        return minCostRecursive(n-1,heights,k);
    }

    private int minCostRecursive(int ind,int[] heights,int k){
        if(ind == 0) return 0;
        int minEng = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(ind-i>=0){
            int curEngy = minCostRecursive(ind-i,heights,k)+Math.abs(heights[ind]-heights[ind-i]);
            minEng = Math.min(curEngy,minEng);
            }
        }
        return minEng;
    }
     public int frogJumpMemo(int[] heights, int k) {
        int n = heights.length;
        int[] memo = new int[n];
        for(int i=0;i<n;i++) memo[i]=-1;
        return minCostMemo(n-1,heights,k,memo);
    }
    private int minCostMemo(int ind,int[] heights,int k,int[] memo){
        if(ind==0) return 0;
        if(memo[ind]!= -1) return memo[ind];
        int minEngy = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
          if(ind-i>=0){  
            int curEngy = minCostMemo(ind-i, heights, k, memo)+Math.abs(heights[ind]-heights[ind-i]);
            minEngy=Math.min(curEngy,minEngy);
          }
        }
        return memo[ind]=minEngy;
    }
    public int frogJumpTabulation(int[] heights, int k) {
        int n = heights.length;
        int[] tabu = new int[n];
        tabu[0]=0;
        for(int i=1;i<n;i++){
           int minSteps= Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if((i-j>=0)){
                   int jump= tabu[i-j]+Math.abs(heights[i]-heights[i-j]);
                   tabu[i]=Math.min(jump,minSteps);
            }
        }
    }
    return tabu[n-1];
}
}
public class Problem4 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] heights={10, 5, 20, 0, 15};
        System.out.println("Recursive:"+s.frogJumpRecursive(heights, 2));
        System.out.println("Memoization:"+s.frogJumpMemo(heights, 2));
        System.out.println("Tabulation:"+s.frogJumpMemo(heights, 2));
    }
}
