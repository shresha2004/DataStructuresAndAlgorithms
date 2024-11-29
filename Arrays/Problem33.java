import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public List<Integer> majorityElementMyBruteForce(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arr= new ArrayList<>();
        int n=nums.length;
        int check=n/3;
        System.out.println(check);
        int count =1;
        if(n<=1 || check==0) {
           for(int num : nums){
            if(! arr.contains(num))
            arr.add(num);
           }
            return arr;}
        for(int i=1;i<n;i++){
          if(nums[i]==nums[i-1]){
            count++;
            if(count > check  ){
             if(! arr.contains(nums[i]))   arr.add(nums[i]);
            }
            
          }
          
          if(nums[i]!=nums[i-1]) {
            count=1;
          }
        }
        return arr;
        
    }
}
public class Problem33 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {3,3,4};
     

    System.out.println("Brute Force Approach:"+(s.majorityElementMyBruteForce(nums)));
 
    }
}
