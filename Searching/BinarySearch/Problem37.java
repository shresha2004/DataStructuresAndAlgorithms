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

    public int kthElementOptimal(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        if(n1>n2) return kthElementOptimal(b,a,k);
        
        int low =  Math.max(0,k-n2);
        int high = Math.min(k,n1);
        int left = k;
        
        while(low <= high){
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1-1 >= 0) l1 = a[mid1-1];
            if(mid2-1 >=0 ) l2 = b[mid2-1];
            if(mid1 < n1) r1 = a[mid1];
            if(mid2 < n2) r2 = b[mid2];
            
            if(l1 <= r2 && l2 <= r1) return Math.max(l1,l2);
            else if(l1 > r2) high = mid1-1;
            else low = mid1 + 1;
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
        System.out.println("Optimal:"+s.kthElementOptimal(a,b,k));
    }
}
