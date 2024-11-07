import java.util.Arrays;

class Solution {
    public int[] rearrangeArrayBruteForce(int[] nums) {
        int n = nums.length;
        int[] pos=new int[n/2];
        int[] neg=new int[n/2];
        int posAdd=0;
        int negAdd=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                pos[posAdd]=nums[i];
                posAdd++;
            }else {
                neg[negAdd]=nums[i];
                negAdd++;
            }
        }
       
        for(int i=0;i<n/2;i++){
            nums[2*i]=pos[i];
            nums[2*i+1]=neg[i];
        }
        return nums;
    }
}
public class Problem21 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {3,1,-2,-5,2,-4};
      System.out.println("BruteForce:"+Arrays.toString(s.rearrangeArrayBruteForce(nums)));
    }
}
