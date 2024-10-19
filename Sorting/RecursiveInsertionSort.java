import java.util.Arrays;

class Solution{
    int i=0;
    public int[] RecursiveSort(int[] nums,int n){
        i++;
        if(n==1){
            return null;
        }
        for(int j=0;j<i;j++){
            if(nums[j]>nums[j+1]){
                int temp=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=temp;
            }
        }

        RecursiveSort(nums, n-1);
        return(nums);
    }
}
public class RecursiveInsertionSort {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums={5,1,3,6};
        System.out.println(Arrays.toString(s.RecursiveSort(nums, 4)));
        
    }
    
}
