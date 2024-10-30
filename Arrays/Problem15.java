//Problem:https://leetcode.com/problems/majority-element/description/

import java.util.HashMap;
class Solution {
    //BruteForce
    public int majorityElementBruteForce(int[] nums) {
        int n=nums.length;
       
        int count=0;
        int majority=0;
       for(int i=0;i<n;i++){
         count=0;
        for(int j=0;j<n;j++){
           
            if(nums[i]==nums[j]){
                count++;
            }
            if(count>n/2){
                majority=nums[j];
                break;
            }
            
            }
            if(count>n/2) break;
        }
         return majority;
       }


       //Optimal Using hash
       public int majorityElementOptimalUsingHash(int[] nums) {
        int n=nums.length;
        int majority=0;
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            hash.put(nums[i],hash.getOrDefault(nums[i],0)+1);
            if(hash.get(nums[i]) > n/2){
                majority=nums[i];
            }
        }
        return majority;

    }

    //Optimal using Moore's voting algorithm
    public int majorityElementOptimal(int[] nums) {
        int n=nums.length;
        int count=0;
        int ele=0;
        
        for(int i=0;i<n;i++){
            if(count==0){
                count=1;
                ele=nums[i];

            }else if(nums[i]==ele){
                count++;
            }
            if(nums[i]!=ele) count--;
        }

        //Verification
        int count1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele){
                count1++;
            }
            if(count1>n/2){
                return ele;
            }
        }
        return -1;

    }
       
        
    }

public class Problem15 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums ={2,2,1,1,1,2,2};
        System.out.println(s.majorityElementBruteForce(nums));
        System.out.println(s.majorityElementOptimalUsingHash(nums));
        System.out.println(s.majorityElementOptimal(nums));
    }
}
