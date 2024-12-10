//Problem: https://leetcode.com/problems/4sum/
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Arrays;
class Solution {
    public List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
        int n= nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i < n-3 ; i++){
            for(int j=i+1; j < n-2;j++){
                for(int k=j+1; k < n-1 ; k++  ){
                    for( int l=k+1;l<n;l++){
                        if(nums[i]+ nums[j] + nums[k] + nums[l] == target){
                            ArrayList<Integer> arr = new ArrayList<>();
                            arr.add(nums[i]);
                            arr.add(nums[j]);
                            arr.add(nums[k]);
                            arr.add(nums[l]);
                            Collections.sort(arr);
                            if(!ans.contains(arr)) ans.add(arr);
                        }
                    }
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> fourSumBetter(int[] nums, int target) {
        int n= nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i < n; i++){
            for(int j=i+1; j < n;j++){
          HashSet<Integer> set = new HashSet<>();

                for(int k=j+1; k < n ; k++  ){
                   int sum = nums[i]+nums[j]+nums[k];
                   int fourth = target - (sum);
                    if(set.contains(fourth)){
                         ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[k]);
                        arr.add(fourth);
                        List<Integer> sorted= sort(arr);
                        if(!ans.contains(sorted)) ans.add(sorted);
                    }
                    set.add(nums[k]);
                    }
                }
            }

        return ans;
    }
    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        int n= nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum = nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum == target){
                        ArrayList<Integer> ls= new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        ls.add(nums[l]);
                      if(!ans.contains(ls))  ans.add(ls);
                    k++;
                    l--;
                    
                    while(k<l && nums[k]==nums[k-1]) k++;
                    while(k<l && nums[l]==nums[l+1]) l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }

   public List<Integer> sort(List<Integer> arr ){
        int n= arr.size();

        for(int i=0;i<n-1;i++){
           int min = i;
            for(int j=i+1;j<n;j++){
             if(arr.get(j)< arr.get(min)){
                min=j;
             }
            }
            if(min != i){
                int temp = arr.get(min);
                arr.set(min,arr.get(i));
                arr.set(i,temp);
            }
        }
      
        return arr;
    }
}

public class Problem35 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {1,0,-1,0,-2,2};
       int target = 0;

    System.out.println("Brute force Approach:"+(s.fourSumBruteForce(nums, target).toString()));
    System.out.println("Better force Approach:"+(s.fourSumBetter(nums, target).toString()));
    System.out.println("Better force Approach:"+(s.fourSumOptimal(nums, target).toString()));
 //   System.out.println("Better force Approach:"+(s.fourSumOptimal(nums, target).toString()));
 //   System.out.println("Better force Approach:"+(s.fourSumOptimal(nums, target).toString()));
 //   System.out.println("Better force Approach:"+(s.fourSumOptimal(nums, target).toString()));
 //   System.out.println("Better force Approach:"+(s.fourSumOptimal(nums, target).toString()));
//   System.out.println("Better force Approach:"+(s.fourSumOptimal(nums, target).toString()));
//   System.out.println("Better force Approach:"+(s.fourSumOptimal(nums, target).toString()));
 
    }
}
