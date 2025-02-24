package BinarySearch;
//Problem:https://leetcode.com/problems/first-bad-version/?envType=problem-list-v2&envId=binary-search

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    

      //Version Control class and isBadVersion is defined inbuilt in question
      public class Solution extends VersionControl {
        public int firstBadVersionBruteForce(int n) {
            
          for(int i=1; i<=n;i++){
            if(isBadVersion(i)){
                return i;
            }
          }
            return -1;
        }

        public int firstBadVersionOptimal(int n) {
        
            int low = 1;
            int high = n;
            int ans=0;
    
            while(low <= high){
                int mid = low + (high-low)/2;
                boolean check = isBadVersion(mid);
                if(check == false){
                    low = mid+1;
                }
                else{
                    ans = mid;
                    high = mid-1;
                }
    
               
            }
            return ans;
        }
    }
public class Problem15 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Brute Force:"+s.firstBadVersionBruteForce(28));
        System.out.println("Optimal:"+s.firstBadVersionOptimal(28));
        
    }
    
}
