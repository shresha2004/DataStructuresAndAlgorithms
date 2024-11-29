//Problem:https://leetcode.com/problems/majority-element-ii/description/
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
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
    public List<Integer> majorityElementBruteForce(int[] nums) {
        int n = nums.length;
        List<Integer> arr= new ArrayList<>();
        int check=n/3;
        int count=0;
        for(int i=0;i<n;i++){
            count=0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]) count++;
                if(count>check) if(!arr.contains(nums[i])) arr.add(nums[i]) ;
            }
        }
        return arr;
    }

    public List<Integer> majorityElementBetter(int[] nums) {
        int n = nums.length;
        List<Integer> arr= new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        int check=n/3;
        
       for(int i=0;i<n;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        int freq=map.get(nums[i]);
        if(freq> check){
           if(!arr.contains(nums[i])) arr.add(nums[i]);
        }
       }
        return arr;
    }
    public List<Integer> majorityElementOptimal(int[] nums) {
        int n = nums.length;
        List<Integer> arr= new ArrayList<>();
       int cnt1=0;
       int cnt2=0;
       int el1= Integer.MIN_VALUE;
       int el2=Integer.MIN_VALUE;

       for(int i=0;i<n;i++){
        if(cnt1 == 0 && el2 != nums[i]){
            cnt1=1;
            el1=nums[i];
        }
        else if(cnt2 == 0 && el1 != nums[i]){
            cnt2=1;
            el2 = nums[i];
        }
        else if (nums[i] == el1) cnt1++;
        else if( nums[i] == el2) cnt2++;
        else{
            cnt1--;
            cnt2--;
        }
       }

       cnt1=0; cnt2=0;
       for(int i=0; i<n;i++){
        if (nums[i] == el1) cnt1++;
        if( nums[i] == el2) cnt2++;
       }

       int mini = (int) (n/3) +1;
       if(cnt1>= mini) arr.add(el1);
       if(cnt2 >= mini) arr.add(el2);
        return arr;
    } 
}
public class Problem33 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {3,3,4};
    System.out.println("My Brute Force Approach:"+(s.majorityElementMyBruteForce(nums)));
    System.out.println("Brute Force Approach:"+(s.majorityElementBruteForce(nums)));
    System.out.println("Better Force Approach:"+(s.majorityElementBetter(nums)));
    System.out.println("Optimal Approach:"+(s.majorityElementOptimal(nums)));
 
    }
}
