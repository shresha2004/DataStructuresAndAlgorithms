//Problem:https://leetcode.com/problems/array-partition/description/?envType=problem-list-v2&envId=sorting
import java.util.*;
class Solution{
 public int arrayPairSum(int[] nums) {
       mergeSort(nums,0,nums.length-1);
        int sum =0;
        for(int i=0;i<nums.length;i+=2)        {
            sum+=nums[i];
        }
        return sum;
    }
    private void mergeSort(int[] nums,int left, int right){
        if(left == right) return;
        int mid = (left+((right-left)/2));
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    private void merge(int[] nums,int left,int mid,int right){
        int i=left;
        int j= mid+1;
        ArrayList<Integer> temp = new ArrayList<>();

        while(i<=mid && j<=right){
            if(nums[j]<nums[i]){
                temp.add(nums[j++]);
            }
            else temp.add(nums[i++]);
        }
        while(i<=mid){
            temp.add(nums[i++]);
        }
        while(j<=right){
            temp.add(nums[j++]);
        }
        int a = 0;
        while(a< temp.size()){
            nums[left+a]=temp.get(a++);
        }
        return;
    }
}
public class Problem72 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { };
        System.out.println("Solution:"+s.arrayPairSum(arr));
    }
}
