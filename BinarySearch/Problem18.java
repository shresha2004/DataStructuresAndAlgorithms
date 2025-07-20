package BinarySearch;
//Problem:https://leetcode.com/problems/koko-eating-bananas/

    class Solution {
        public int minEatingSpeedBruteForce(int[] piles, int h) {
            int n = piles.length;
            int maxEle = maxElement(piles,n);
            for(int i = 1; i<= maxEle;i++){
                int totalHour = requiredHour(piles,i,n);
                if(totalHour <= h) return i;
            }
            return 0;
        }

        public int minEatingSpeedOptimal(int[] piles, int h) {
            int n = piles.length;
            int maxEle = maxElement(piles,n);
           // int ans =0;
            int low = 0;
            int high = maxEle;
            while(low <= high){
                int mid = (low+high)/2;
                int totalHour = requiredHour(piles,mid,n);
                if(totalHour <= h)  high = mid-1;
                else{
                   low = mid+1;
                }
            }
            return low;
        }

        private int maxElement(int[] piles,int n){
            int max = Integer.MIN_VALUE;
            for(int num : piles){
                if(num > max) max = num;
            }
            return max;
        }
        private int requiredHour(int[] piles,int i,int n){
            int totalHour = 0;
            for(int j = 0; j<n; j++){
                totalHour += Math.ceil((double)(piles[j])/(double)(i));
            }
            return totalHour;
        }
    }


public class Problem18 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println("Brute Force:"+s.minEatingSpeedBruteForce(piles,h));
        System.out.println("Optimal:"+s.minEatingSpeedOptimal(piles,h));
    }
}
