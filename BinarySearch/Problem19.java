package BinarySearch;
//Problem:https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

class Solution {
    public int minDaysBruteForce(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int totalFlowersReq = m*k;
        if(n < totalFlowersReq) return -1;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            min = Math.min(bloomDay[i],min);
            max = Math.max(bloomDay[i],max);
        }

        for(int i =min ; i<=max;i++){
            if(possible(bloomDay,i,k,m)) return i;
        }

        return -1;
    }

    public int minDaysOptimal(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long totalFlowersReq = (long) m*k;
        if(n < totalFlowersReq) return -1;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            min = Math.min(bloomDay[i],min);
            max = Math.max(bloomDay[i],max);
        }
        int low = min;
        int high = max;
        while(low <= high){
            int mid = (low+high)/2;
            if(possible(bloomDay,mid,k,m)) {
               
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        
        }
        return low;
    }

    private boolean possible(int[] bloomDay, int day,int k, int m){
        int n = bloomDay.length;
        int count =0;
        int noOfBouquets = 0;
        for(int i=0; i<n;i++ ){
            if(bloomDay[i] <= day) count++;
            else{
                noOfBouquets += (count/k);
                count =0;
            }
        }
        noOfBouquets += (count/k);

        if(noOfBouquets >= m) return true;
        return false;
    }
}

public class Problem19 {
    public static void main(String[] args) {
        Solution s = new Solution();
      int[]  bloomDay = {1,10,3,10,2};
      int m = 3;
      int  k = 1;
        System.out.println("Brute Force:"+s.minDaysBruteForce(bloomDay,m,k));
        System.out.println("Optimal:"+s.minDaysOptimal(bloomDay,m,k));
    }
}
