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
    public int[] rearrangeArrayBetter(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int even=0;
        int odd=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr[even*2]=nums[i];
                 even++;
                
            }
            if(nums[i]<0){
                arr[odd*2+1]=nums[i];
               odd++;
            }
        }
        return arr;
    }
}
public class Problem21 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {3,1,-2,-5,2,-4};
      System.out.println("BruteForce:"+Arrays.toString(s.rearrangeArrayBruteForce(nums)));
      System.out.println("Better:"+Arrays.toString(s.rearrangeArrayBetter(nums)));
    }
}
