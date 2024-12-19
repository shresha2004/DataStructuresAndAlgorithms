class Solution {
    // Function to count inversions in the array.
    static int inversionCountBruteForce(int arr[]) {
        // Your Code Here
        int n= arr.length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i]>arr[j] && i<j){
                    count++;
                }
            }
        }
        return count;
    }
}
public class Problem41 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] arr = {2, 4, 1, 3, 5};
       System.out.println("Brute Force Approach:"+s.inversionCountBruteForce(arr)); 
      // System.out.println("Better Approach:"+s.findTwoElementBetter(arr)); 
       //System.out.println("Optimal Approach 1:"+s.findTwoElementOptimal1(arr));
    }
}
