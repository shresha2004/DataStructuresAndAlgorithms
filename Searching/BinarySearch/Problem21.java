package BinarySearch;
//Problem:https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
class Solution {
    public int shipWithinDaysBruteForce(int[] weights, int days) {
        int n = weights.length;
        int arrSum = 0;
        int maxEle = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
           arrSum += weights[i];
            maxEle = Math.max(maxEle, weights[i]);
        }
        
        for(int check = maxEle; check<=arrSum;check++){
            int checkDays = checkLeast(weights,check);
            if(checkDays <= days) return  check;
        }
       return 0; 
    }


    public int shipWithinDaysOptimal(int[] weights, int days) {
        int n = weights.length;
        int arrSum = 0;
        int maxEle = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
           arrSum += weights[i];
            maxEle = Math.max(maxEle, weights[i]);
        }
        int low = maxEle;
        int high = arrSum;
        while(low<= high){
            int mid = (low + high)/2;
            int checkDays = checkLeast(weights,mid);
            if(checkDays <= days) high = mid-1;
            else if(checkDays > days) low = mid+1;
        }
       return low; 
    }
    private int checkLeast(int[] weights, int check){
        int n = weights.length;
        int wtSum =0;
        int dayCount = 1;
        for(int i = 0;i<n;i++){
           if(wtSum + weights[i] > check){
                wtSum = weights[i];
                dayCount++;

           }
           else wtSum += weights[i];
           
        }
       return dayCount ;
    }
}

public class Problem21 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] weights = {1,2,3,4,5,6,7,8,9,10};
       int days = 5;
        System.out.println("Brute Force:"+s.shipWithinDaysBruteForce(weights,days));
        System.out.println("Optimal:"+s.shipWithinDaysBruteForce(weights,days));
    }
}
