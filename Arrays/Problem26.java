 //Problem:https://www.naukri.com/code360/problems/longest-successive-elements_6811740?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems

import java.util.Arrays;

class Solution {
    public static int longestSuccessiveElementsBruteForce(int []a) {
        // Write your code here.
        int n=a.length;
        boolean swapped;
        for(int i=n-1;i>=0;i--){
            swapped=false;
            for(int j=0;j<n-1;j++){
            if(a[j+1]<a[j]){
                int temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
                swapped=true;
            }

            }
            if(!swapped) break;
        }
        System.out.println(Arrays.toString(a));
        int duplicate=0;
        int maxDuplicate=0;
        for(int i=1;i<n;i++){
            int check=a[i] - a[i-1];
          
            
            if(check==1  ){ 
                duplicate++;
                }
            if(check !=0 && check !=1 || i==n-1){
                 maxDuplicate=Math.max(maxDuplicate,duplicate);
                 duplicate=0;
            } 

                }
        return maxDuplicate+1;
    }
}
public class Problem26 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {
        147, 25, 56, 168, 106, 124, 137, 117, 15, 45, 189, 92, 74, 46, 63, 20,
        198, 20, 78, 73, 111, 90, 152, 49, 6, 121, 70, 158, 3, 135, 148, 11, 155,
        166, 45, 187, 83, 39, 36, 14, 35, 70, 142, 149, 182, 96, 134, 192, 105,
        42, 16, 118, 137, 107, 50, 5, 186, 101, 96, 18, 166, 168, 200, 28, 178,
        23, 53, 20, 135, 23, 16, 103         };
      System.out.println("BruteForce Approach:"+s.longestSuccessiveElementsBruteForce(nums));
    // System.out.println("Optimal Approach:"+s.leadersOptimal(nums));
 
    }
    
}
