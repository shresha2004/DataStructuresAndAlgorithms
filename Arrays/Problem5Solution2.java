import java.util.Arrays;
class Solution {
    public int[] moveZeroes(int[] nums) {
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

public class Problem5Solution2 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a= {0,1,0,3,12};
        System.out.println(Arrays.toString(s.moveZeroes(a)));
    }
    
}
