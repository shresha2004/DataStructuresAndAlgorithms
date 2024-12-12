//Problem:https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1?category%5B%5D=Hash&company%5B%5D=Amazon&page=1&query=category%5B%5DHashcompany%5B%5DAmazonpage1company%5B%5DAmazoncategory%5B%5DHash&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-subarray-with-0-sum
import java.util.HashMap;
class Solution {
    int maxLenBruteForce(int arr[]) {
        // code here
        int n=arr.length;
        int maxLength=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+arr[j];
                if(sum==0){
                    maxLength=Math.max(j-i+1,maxLength);
                }
            }
        }
        return maxLength;
    }
    int maxLenOptimal(int arr[]) {
        // code here
        int n=arr.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        int maxLength=0;
        int j=0;
        int k=0;
         int sum=0;
        for(int i=0;i<n;i++){
                sum=sum+arr[i];
                if(sum==0) maxLength=i+1;
                else{
                    if(map.get(sum)!= null){
                        maxLength=Math.max(maxLength,i - map.get(sum));
                    }
                    else{
                        map.put(sum,i);
                    }
                }
                
            
        }
        return maxLength;
    }
}
public class Problem36 {
    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = {-1,0,1,2,-1,-4};
    System.out.println("Brute Force Approach:"+ s.maxLenBruteForce(nums));
    System.out.println("Optimal Approach:"+ s.maxLenOptimal(nums));
    }
}
