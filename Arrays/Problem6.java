//Problem:https://leetcode.com/problems/remove-element/description/?envType=problem-list-v2&envId=array&difficulty=EASY
import java.util.Arrays;
class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int j=-1;
        int i;
        int k=0;

        for( i=0;i<n;i++){
           // k++;
            if(nums[i]==val){
                j=i;
               
                break;
            }
        }
            if(j==-1) return nums.length;

            for( i=j+1;i<n;i++){
                if(nums[i]!=nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                   
                    j++;
                }
            }

            for(i=0;i<n;i++){
                if(nums[i]==val){
                   break;
                }
                k++;
            }
         
        
        System.out.println(Arrays.toString(nums));
        return k;
        
    }
}
public class Problem6 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr={1,2,4,5,2,2,5,3,2};
        System.out.println(s.removeElement(arr, 2));
    }
}
