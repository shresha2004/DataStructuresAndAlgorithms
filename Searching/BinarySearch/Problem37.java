//Problem:https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-th-element-of-two-sorted-array
package BinarySearch;
class Solution {
    public int kthElementBruteForce(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        int[] merged = new int[n1+n2];
        
        int left = 0;
        int right = 0;
        int i =0;
        while(left < n1 && right < n2){
            if(a[left] < b[right]){
                merged[i]=a[left++];
            }
            else {
                merged[i]=b[right++];
            }
            i++;
        }
        
        while(left < n1){
            merged[i]=a[left++];
            i++;
        }
        while(right < n2){
            merged[i]=b[right++];
            i++;
        }
        return merged[k-1];
    }

    public int kthElementBetter(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        int count =0;
        
        int left = 0;
        int right = 0;
        while(left < n1 && right < n2){
            if(a[left] < b[right]){
                count++;
                if(count == k) return a[left];
                left++;

            }
            else {
                
                count++;
                if(count == k) return b[right];
                right++;
            }
        }
        
        while(left < n1){
            
            count++;
            if(count == k) return a[left];
            left++;
        }
        while(right < n2){
            
            count++;
            if(count == k) return b[right];
            right++;
            }
        return 0;
    }
}

public class Problem37 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {2, 3, 6, 7, 9}, b = {1, 4, 8, 10};
        int k = 5;
        System.out.println("Brute Force:"+s.kthElementBruteForce(a,b,k));
        System.out.println("Better:"+s.kthElementBetter(a,b,k));
    }
}
