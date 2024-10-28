//Problem:https://leetcode.com/problems/sort-colors/description/
import java.util.Arrays;
class Solution {
    public int[] sortColorsBruteForce(int[] nums) {
        int n =nums.length;
        for(int i=0;i<n-1;i++){
           int min=i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
               
            }
             if(min!=i){
                int temp = nums[min];
                nums[min]=nums[i];
                nums[i]=temp;
            }
        }
        return nums;
    }
    public int[] sortColorsBetter(int[] nums) {
        int n =nums.length;
        int count0=0;
        int count1=0;
        int count2=0;
        int i,j,k;
        for( i=0;i<n;i++){
            if(nums[i]==0) count0++;
            if(nums[i]==1) count1++;
            if(nums[i]==2) count2++;
           
        }
        System.out.println(count0+" "+count1+" "+count2);
        for(i=0;i<count0;i++){
            nums[i]=0;
        }
        for(j=i;j<count0+count1;j++){
            nums[j]=1;
        }
        for(k=j;k<count0+count1+count2;k++){
            nums[k]=2;
        }
        return nums;
    }

    //Dutch National Flag method
    public int[] sortColorsOptimal(int[] nums) {
        int n =nums.length;
        int mid=0;
        int low=0;
        int heigh=n-1;
        while(mid<=heigh){
            if(nums[mid]==0) {
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1) mid++;
            else {
                swap(nums,mid,heigh);
                heigh--;
               
            }
        }
        return nums;
    }
    private void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
public class Problem13 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] nums ={2,0,2,1,1,0};
        System.out.println("Brute force:"+Arrays.toString(s.sortColorsBruteForce(nums)));
        System.out.println("Better:"+Arrays.toString(s.sortColorsBruteForce(nums)));
        System.out.println("Optimal:"+Arrays.toString(s.sortColorsBruteForce(nums)));
    }
}
