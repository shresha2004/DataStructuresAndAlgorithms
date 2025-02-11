package BinarySearch;
//problem:https://www.naukri.com/code360/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTabValue=PROBLEM

import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public  int findPagesBruteForce(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(n < m) return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<n;i++){
            if(arr.get(i)>low) low = arr.get(i);
            high += arr.get(i);
        }

        for(int pages = low; pages <= high;pages++){
            if(countStudents(arr,pages)==m) return pages;
        }

        return low;

    }
    public  int findPagesOptimal(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(n < m) return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<n;i++){
            if(arr.get(i)>low) low = arr.get(i);
            high += arr.get(i);
        }

        while(low <= high){
            int mid = (low+high)/2;
            int check = countStudents(arr,mid);
            if(check > m) low = mid+1;
            else high = mid-1;
        }

        return low;
    }

    private  int countStudents(ArrayList<Integer> arr,int pages){
        int n = arr.size();
        int Students = 1;
        int pagesStudents = 0;

        for(int i =0;i<n;i++){
            if(arr.get(i)+pagesStudents <= pages){
                pagesStudents += arr.get(i);
            }
            else {
                Students++;
                pagesStudents = arr.get(i);
            }
        }
    return Students;

    }
}
public class Problem26 {
    public static void main(String[] args){
        Solution s = new Solution();
ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int n = 4;
        int m = 2 ;
        System.out.println("Brute Force:"+s.findPagesBruteForce(arr,n,m));
        System.out.println("Optimal:"+s.findPagesOptimal(arr,n,m));
    }
}
