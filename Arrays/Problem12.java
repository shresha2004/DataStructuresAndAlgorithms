//Problem:https://leetcode.com/problems/two-sum/description/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
class Solution{


    //Brute Force
    public int[] twoSumBruteForce(int[] nums,int target){
        int n=nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(i==j)continue;
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
            
        }
        return new int[0];
    }


   //Better Solution(Without using hash map)
    public int[] twoSumBetter(int[] nums,int target){
    int n=nums.length;
    int j=0;
    //Selection sort
    for(int i=0;i<n-1;i++){
    int min=i;
    for( j=i+1;j<n;j++){
        if(nums[j]<nums[min]){
            min=j;
        }
    }
    if(min!=i){
        int temp=nums[i];
        nums[i]=nums[min];
        nums[min]=temp;

    }
    }
    System.out.println(Arrays.toString(nums));
  int left=0;
  int right=n-1;
  int i=0;
  while(i<n){
    int check=nums[left]+nums[right];
    if(check==target){
        return new int[] {left,right};
    }
    if(check>target){
        right--;
    }
    if(check<target){
        left++;
    }
  }

return new int[0];
   }

    //Optimal Solution
    public int[] twoSumOptimal(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[] {(map.get(complement)),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];

    }

    
}
public class Problem12 {
    
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums ={2,11,7,15};
        int target=9;
       System.out.println("Brute Force:"+Arrays.toString( s.twoSumBruteForce(nums, target)));
       System.out.println("Better:"+Arrays.toString( s.twoSumBetter(nums, target)));
       System.out.println("Optimal:"+Arrays.toString( s.twoSumOptimal(nums, target)));

    }
}
