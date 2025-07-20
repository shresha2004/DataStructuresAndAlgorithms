package BinarySearch;
import java.util.Arrays;
class Solution {
    public int[] twoSumBruteForce(int[] numbers, int target) {
        
        int n =numbers.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(numbers[i]+numbers[j]==target) return new int[] {i+1,j+1};
            }
        }
        return null;
    }
    public int[] twoSumOptimal(int[] numbers, int target) {
        
        int n =numbers.length;
       int low = 0;
       int high = n-1;
      while(low <=high){
        if(numbers[low]+numbers[high]>target) high--;
        if(numbers[low]+numbers[high]<target) low++;
        if(numbers[low]+numbers[high]==target) return new int[] {low+1,high+1};
      }
        return null;
    }
}
public class Problem32 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println("Brute Force:"+Arrays.toString(s.twoSumBruteForce(numbers,target)));
        System.out.println("Optimal:"+Arrays.toString(s.twoSumOptimal(numbers,target)));
    }
}
