package BinarySearch;
//Problem:https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root

class Solution {
    int floorSqrtBruteForce(int n){
        int ans =0;
        for(int i=1; i<n;i++){
            int check = i*i;
            if(check <= n){
                ans = i;
            }else{
                break;
            }
        }
        return ans;
    }

    int floorSqrtOptimal(int n) {
    int low = 0;
    int high = n;
    int ans = 1;
    //Binary Search
    while(low<= high){
        int mid = (low+high)/2;
        int check = mid * mid;
        if (check > n) {
            high = mid-1;
        }
        else if (check <= n) {
            ans = mid;
            low = mid+1;
        }
    }
    return ans;
    }
}
public class Problem14 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Brute Force:"+s.floorSqrtBruteForce(28));
        System.out.println("Optimal:"+s.floorSqrtBruteForce(28));
        
    }
}
