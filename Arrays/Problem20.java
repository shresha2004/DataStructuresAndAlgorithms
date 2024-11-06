//Problem:https://leetcode.com/problems/best-time-to-buy-and-sell-stock/



class Solution {
    public int maxProfitBruteForce(int[] prices) {
        int n= prices.length;
        
        int maxProf=0;
          int prof=0;
        for(int i=0;i<n-1;i++){
          
            for(int j=i+1;j<n;j++){
                prof=prices[j]-prices[i];

                if(prof>0 && prof>maxProf){
                    maxProf=prof;
              
                }

            }
        }
       return maxProf; 
    }
    public int maxProfitOptimal(int[] prices) {
        int n= prices.length;
        int min=prices[0];
        int maxProf=0;
       
       for(int i=1;i<n;i++){
        int cost=prices[i]-min;
        maxProf=Math.max(cost,maxProf);
        min=Math.min(prices[i],min);
       
    }
    return maxProf;
}
}
public class Problem20 {
    public static void main(String[] args) {
        int[] digits = {7,1,5,3,6,4};
        Solution s= new Solution();
        System.out.println("BruteForce:"+s.maxProfitBruteForce(digits));
        System.out.println("Optimal:"+s.maxProfitOptimal(digits));
    }
}
