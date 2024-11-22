 //Problem:https://www.naukri.com/code360/problems/longest-successive-elements_6811740?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems

import java.util.Arrays;
import java.util.HashSet;

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
    
    public static int longestSuccessiveElementsOptimal(int []a) {
        // Write your code here.
        int n=a.length;
        int length=Integer.MIN_VALUE;
        if(n==0) return 0;
        HashSet<Integer> set =new HashSet<>();
        for(int ele : a){
            set.add(ele);
        }
        for(int ele : set){
        if(!set.contains(ele-1)){
            int cnt=1;
           
            int x=ele;
            while(set.contains(x+1)){
                x=x+1;
                cnt++;
            }
            length=Math.max(cnt,length);
        }
       
        }
        return length;
    }
}
public class Problem26 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = { 5, 8, 3, 2, 1, 4,4};
    System.out.println("BruteForce Approach:"+s.longestSuccessiveElementsBruteForce(nums));
     System.out.println("Optimal Approach:"+s.longestSuccessiveElementsOptimal(nums));
 
    }
    
}
