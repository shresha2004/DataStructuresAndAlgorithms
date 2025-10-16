
 class Solution {
    public  int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int low = 0;
        int high = n-1;
        int ans = n;
        while( low <= high){
            int mid = (low + high)/2;

            if(x <= arr[mid]){
                ans = mid ;
                high = mid -1;
            }
            else if (x > arr[mid]){
                low = mid+1;
            }
        }
        return ans;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr={1 ,2, 2, 3, 3 ,5};
        int x = 4;
        int n = 6;
        System.out.println("Optimal:"+s.lowerBound(arr,n,x));
      
        
    }
}
