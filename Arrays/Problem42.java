class Solution {
    public int reversePairsBruteForce(int[] nums) {
        int n =nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                long check= 2L *  nums[j];
                if(i<j && nums[i]>check) count++;
            }
        }
       return count; 
    }
    public int reversePairsOptimal(int[] nums) {
        int n =nums.length;
        int count=0;
       int low=0;
       int high=n-1;
      count= mergeSort(nums,low,high);
       return count; 
    }

    public int mergeSort(int[] nums, int low,int high){
        int count = 0;
        if(low<high){
           int mid=(low+high)/2;
        count += mergeSort(nums,low,mid);
      count += mergeSort(nums,mid+1,high);
        count += countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        }
        
      return count;
    }
    public int countPairs(int[] nums,int low, int mid,int high){
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
           while(right<=high && nums[i]> 2L*nums[right]){
            right++;
           }
           count+=(right - (mid+1));

        }
        return count;
    }
    public void merge(int[] nums,int low,int mid,int high){
        
        int left = low;
        int right =mid+1;
        int k=0;
        int[] temp = new int[high-low+1];
        

        while(left<= mid && right <= high ){
            if(nums[left] <= nums[right]){
                temp[k++] = nums[left++];
                
            }
            else {
                temp[k++]=nums[right++];
               
            }
        }
        while(left<=mid){
            temp[k++]=nums[left];
            left++;
        }
        while(right <= high){
            temp[k++]=nums[right++];

        }
        for(int i=0;i<temp.length;i++){
            nums[low+i]=temp[i];
        }
       
    }
}
public class Problem42 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] arr = {1,3,2,3,1};
       System.out.println("Brute Force Approach:"+s.reversePairsBruteForce(arr)); 
   System.out.println("Optimal Approach:"+s.reversePairsOptimal(arr)); 
    }
}
