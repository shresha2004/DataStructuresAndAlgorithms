//Problem:https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        
        // add your code here
        int n1=a.length;
        int n2=b.length;
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<n1;i++){
            h.add(a[i]);
        }
        
        for(int i=0;i<n2;i++){
            h.add(b[i]);
        }
        int n=h.size();
        ArrayList<Integer> arr= new ArrayList<>(h);
        Collections.sort(arr);
        return arr;
    }
}
public class Problem7 {
    public static void main(String[] args) {
    Solution s=new Solution();
    int[] a= {1, 2, 3, 4, 5};
    int[] b = {1, 2, 3, 6, 7};
    System.out.println(s.findUnion(a, b));
    }
    
}
