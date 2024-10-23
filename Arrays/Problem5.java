import java.util.Arrays;

class Solution {
    public int[] moveZeroes(int[] nums) {
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
}
public class Problem5 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] a={0,1,0,3,12};
        System.out.println(Arrays.toString(s.moveZeroes(a)));
    }
    
}
