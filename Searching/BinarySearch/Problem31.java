package BinarySearch;
class Solution {
    public int specialArrayBruteForce(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++) max=Math.max(max,nums[i]);
        for(int i=0;i<=max;i++){
            int count =0;
            for(int j = 0;j<n;j++){
                if(nums[j]>=i)count++;
               if(count > i) break;
            }
             if(count==i) return count;
        }
        return -1;      
    }

    public int specialArrayOptimal(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++) max=Math.max(max,nums[i]);
        int low = 0;
        int high = max;
        while(low<=high){
            int mid = (low+high)/2;
            int count = check(mid,nums);
             if(count==mid) return mid;
             if(count>mid) low = mid+1;
             if(count < mid) high =mid-1;
        }
        return -1;      
    }
    private int check(int num,int[] nums){
        int n = nums.length;
        int count = 0;
        for(int j = 0;j<n;j++){
                if(nums[j]>=num)count++;
               
            }
            return count;
    }
}

public class Problem31 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,4,3,0,4};
        System.out.println("Brute Force:"+s.specialArrayBruteForce(nums));
        System.out.println("Optimal:"+s.specialArrayOptimal(nums));
    }
}
