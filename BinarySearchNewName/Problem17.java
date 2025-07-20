package BinarySearch;
//Problem:https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m
class Solution {
    public int nthRootBruteForce(int n, int m) {
        // code here
        if(n == 0 && m<0) return -1;
        if(n==1) return m;
        for(int i = 1 ; i<=m; i++){
            int check =1;
            for(int j=0; j<n; j++){
                check= check * i;
                if(check > m) return -1;
            }
            
            if(check == m) return i;
        }
        return -1;
        
    }
    public int nthRootOptimal(int n, int m) {
        // code here
        if(n == 1) return m;
        if(n == 0 && m<0) return -1;
       int left = 0;
       int right = m;
       
       while(left <= right){
           int mid = left + (right - left)/2 ;
           int check = power(mid,n);
           if(check == m) return mid;
           else if(check > m) right = mid-1;
           else left = mid+1;
       }
       return -1;
    }
    
    private int power(int base, int power){
        int ans = 1;
        for(int i = 1; i<= power; i++){
            ans *= base;
        }
        return ans;
    }
}
public class Problem17 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("My Brute Force:"+s.nthRootBruteForce(4,16));
        System.out.println("Optimal:"+s.nthRootOptimal(4,16));
    }
}
