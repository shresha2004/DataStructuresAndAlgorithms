import java.util.Arrays;
class Solution {
    public int[] mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        int size=m+n;
        int j=0;
        for(int i=m;i<size;i++){
            nums1[i]=nums2[j];
            j++;
        }
        System.out.println(Arrays.toString(nums1));
        for(int i=0;i<size-1;i++){
           int min=i;
            for(int k=i;k<size;k++){
                if(nums1[min]>nums1[k]){
                    min=k;
                }
            }
            if(min!=i){
                int temp=nums1[min];
                nums1[min]=nums1[i];
                nums1[i]=temp;
            }

        }
        return nums1;
    }
}

public class Problem18 {
    public static void main(String[] args) {
       int[]  nums1 = {1,2,3,0,0,0};
       int m = 3; 
       int[] nums2 = {2,5,6};
       int n = 3;
        Solution s= new Solution();
        System.out.println("BruteForce:"+Arrays.toString(s.mergeBruteForce(nums1,m,nums2,n)));
      //  System.out.println("Optimal:"+Arrays.toString(s.plusOneOptimal(digits)));
    }
}
