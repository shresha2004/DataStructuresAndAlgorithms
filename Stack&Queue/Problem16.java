//Problem:https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1
import java.util.Arrays;
class Solution {
    public static int[] count_NGEsBruteForce(int arr[],  int indices[]) {
        // code here
        int[] ans = new int[indices.length];
        for(int i=0;i<indices.length;i++){
            int count = 0;
            for(int j=indices[i]+1;j<arr.length;j++){
                if(arr[j]>arr[indices[i]]) count++;
            }
            ans[i]=count;
        }
        return ans;
    }
}

public class Problem16 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6}, indices = {0, 5};
        System.out.println("Brute force:"+Arrays.toString(s.count_NGEsBruteForce(arr,  indices)));
    }
}
