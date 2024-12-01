//Problem:https://leetcode.com/problems/3sum/description/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Arrays;
class Solution {
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        int n=nums.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[k]);
                        Collections.sort(arr);
                        if(!ans.contains(arr))
                        ans.add(arr);
                    }
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> threeSumBetter(int[] nums) {
        int n=nums.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-1;i++){
           HashSet<Integer> set = new HashSet<>();
            for(int j=i+1;j<n;j++){
               int third= -(nums[i]+nums[j]);
               if(set.contains(third)){
                List<Integer> arr= new ArrayList<>();
                arr.add(nums[i]);
                arr.add(third);
                arr.add(nums[j]);
                Collections.sort(arr);
               if(!ans.contains(arr)) ans.add(arr);
               }
               set.add(nums[j]);
            }
            }
        return ans;

        }
        public List<List<Integer>> threeSumOptimal(int[] nums) {
            int n=nums.length;
            //Sorting
            int[] sortedNums=sort(nums);
            System.out.println(Arrays.toString(sortedNums));
            
            List<List<Integer>> ans = new ArrayList<>();
            for(int i=0;i<n;i++){
              if(i>0 && sortedNums[i]==sortedNums[i-1]) continue;
              int j=i+1;
              int k=n-1;
              while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0) j++;
               else if(sum>0) k--;
               else{
                ArrayList<Integer> a= new ArrayList<>();
                a.add(nums[i]);
                a.add(nums[j]);
                a.add(nums[k]);
                ans.add(a);
                j++;
                k--;
                while(j<k && sortedNums[j]==sortedNums[j-1]) j++;
                while(j<k && sortedNums[k]==sortedNums[k+1]) k--;
               }
    
    
              }
             
    
                }
            return ans;
    
            }
            //Sorting(Selection sort)
            public int[] sort(int[] arr){
                int n=arr.length;
                for(int i=0;i<n-1;i++){
                    int min=i;
                    for(int j=i;j<n;j++){
                        if(arr[j]<arr[min]) min=j;
                    }
                    if(min != i){
                        int temp= arr[i];
                        arr[i]=arr[min];
                        arr[min]= temp;
                    }
                }
                return arr;
            }
}
public class Problem34 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {-1,0,1,2,-1,-4};
    System.out.println("Brute Force Approach:"+ s.threeSumBruteForce(nums).toString());
    System.out.println("Better Approach:"+ s.threeSumBetter(nums).toString());
    System.out.println("Optimal Approach:"+ s.threeSumBetter(nums).toString());
   
 
    }
}
