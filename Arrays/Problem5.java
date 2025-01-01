//Problem:https://leetcode.com/problems/move-zeroes/description/
import java.util.Arrays;

class Solution {
    public int[] moveZeroesBruteForce(int[] nums) {
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                for(int j=i+1;j<n;j++){
                    if(nums[j]!=0){
                        int temp=nums[i];
                        nums[i]=nums[j];
                        nums[j]=temp;
                        break;
                    }
                }

            }
        }
        return nums;
        
    }
    public int[] moveZeroesOptimal(int[] nums) {
        int n=nums.length;
        int j=-1;
         
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                j=i;
                break;
                }

            }
            if(j==-1) return nums;
        for(int i=j+1;i<n;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
        return nums;
        }
}
public class Problem5 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] a={0,1,0,3,12};
        System.out.println(Arrays.toString(s.moveZeroesBruteForce(a)));
        System.out.println(Arrays.toString(s.moveZeroesOptimal(a)));
    }
    
}
