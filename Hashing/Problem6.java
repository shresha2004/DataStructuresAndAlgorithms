//Problem:https://leetcode.com/problems/two-sum/description/?envType=problem-list-v2&envId=hash-table&favoriteSlug=&difficulty=EASY
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        int[] ans = new int[2];
        int i=0;
        for(int num : nums){
           hash.put(num,i);
            i++;
        }
        System.err.println(hash);
        for(i=0;i< nums.length;i++){
            int comp=target-nums[i];
            System.out.print(hash.get(comp));
            if(hash.containsKey(comp) && hash.get(comp)!=i){
               
                  ans[0]=i;
                ans[1]=hash.get(comp);
              
            }
        }
        return ans;
    }
}
public class Problem6 {
    public static void main(String[] args) {

        Solution s= new Solution();
        int[] arr={3,3,3};
       System.out.println(s.twoSum(arr, 6)); 
    }
    
}
