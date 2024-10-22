import java.util.Arrays;
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        for(int i=0;i<k;i++){
            int temp=nums[n-1];
            for(int j=nums.length-1;j>0;j--){
                nums[j]=nums[j-1];

            }
            nums[0]=temp;
        }
        System.out.println(Arrays.toString(nums));
        
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={1,2,3,4,5,6,7};
        s.rotate(a, 3);

    }
    
}
