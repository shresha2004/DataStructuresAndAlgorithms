import java.util.Arrays;
class Solution{
 public  int[] quickSort(int[] nums,int low ,int high){
        if(low<high){
        int p=partition(nums,low,high);
        quickSort(nums, low,p-1);
        quickSort(nums, p+1, high);
        }
    
            return nums;
    }
   public int partition(int[] nums,int low,int high){
    int pivot=nums[low];
    int i=low;
    int j=high;
    while(i<=j){
        while(i<=high && nums[i]<= pivot) i++;
        while(j>=low && nums[j]> pivot) j--;
        if(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
    int temp=nums[j];
    nums[j]=nums[low];
    nums[low]=temp;

        return j;
    }

   
}
public class QuickSort {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr = { 4, 1, 3, 9, 7};
       System.out.println(Arrays.toString(s.quickSort(arr, 0, 4))); 
    }
    
}
