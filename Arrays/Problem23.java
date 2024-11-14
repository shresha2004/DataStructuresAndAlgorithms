//Problem:https://leetcode.com/problems/summary-ranges/description/?envType=problem-list-v2&envId=array&difficulty=EASY
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> summaryRangesOptimal(int[] nums) {
        List<String> ls= new ArrayList<>();
        int n=nums.length;
        int flag=0;
        int number=0;
        int flag2=0;
       if(n<1) return ls;
        for(int i=0;i<n-1;i++){
            if(nums[i]+1==nums[i+1] && flag==0){
                number=nums[i];
                flag=1;
            }else if(flag==0){
                ls.add(Integer.toString(nums[i]));
            }
            if(flag==1 && nums[i]+1!=nums[i+1]){
                ls.add(number+"->"+nums[i]);
                flag=0;
            }else if(nums[i]+1 == nums[n-1] && flag==1){
                ls.add(number+"->"+nums[n-1]);
                flag2=1;
            }
        }
        if(flag2==0) ls.add(Integer.toString(nums[n-1]));
        return ls;
    }
    public List<String> summaryRangesBruteForce(int[] nums) {
        List<String> ls= new ArrayList<>();
        if(nums == null || nums.length==0) return ls;
        int start=0;
        for(int i=1;i<=nums.length;i++){
            if(i==nums.length || nums[i] != nums[i-1] +1){
                if(start == i-1){
                    ls.add(String.valueOf(nums[start]));
                }else{
                    ls.add(nums[start] + "->" + nums[i - 1]);
                }
                start=i;
            }
        }
        return ls;
    }
}
public class Problem23 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {0,1,2,4,5,7};
      System.out.println("BruteForce Approach:"+s.summaryRangesBruteForce(nums));
      System.out.println("Optimal Approach:"+s.summaryRangesOptimal(nums));
     
    }
}
