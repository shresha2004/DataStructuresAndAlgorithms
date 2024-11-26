import java.util.HashMap;
class Solution {
    public int subarraySumBruteForce(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
               sum=sum+nums[j];
               if(sum==k) count++;
            }
        }
        return count;
    }
    public int subarraySumOptimal(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int sum=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
          int remove=sum-k;
          count+=map.getOrDefault(remove,0);
          map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
public class Problem30 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {1,2,3};
       int k = 3;
    System.out.println("BruteForce Approach:"+s.subarraySumBruteForce(nums,k));
    System.out.println("Optimal Approach:"+s.subarraySumOptimal(nums,k));
 
    }
    
}
