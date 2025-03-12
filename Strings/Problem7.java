//Problem:https://leetcode.com/problems/valid-anagram/description/
import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public boolean isAnagramBruteForce(String s, String t) {
        if(s.length()!= t.length()) return false;
         char[] charArrS = s.toCharArray();
         char[] charArrT = t.toCharArray();
         mergeSort(charArrS,0,charArrS.length-1);
         mergeSort(charArrT,0,charArrT.length-1);
         return Arrays.equals(charArrS,charArrT);
    }

    public boolean isAnagramOptimal(String s, String t) {
        if(s.length()!= t.length()) return false;
         int[] count = new int[26];
         for(int i=0;i<s.length();i++){
            count[(s.charAt(i)-'a')]++;
            count[(t.charAt(i)-'a')]--;
         }
         for(int val: count){
            if(val != 0) return false;
         }
         return true;
    }
    
    private void mergeSort(char[] arr,int low,int high){
        if(high<=low) return;
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private void merge(char[] arr,int low,int mid,int high){
        int left = low;
        int right = mid+1;
        ArrayList<Character> temp= new ArrayList<>();
        while(left <= mid && right<=high){
            if(arr[left]<arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left++]);
        }
        while(right <= high){
            temp.add(arr[right++]);
        }
        int j=0;
        for(int i=low;i<=high;i++){
            arr[i]=temp.get(j++);
        }
}
}

public class Problem7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "anagram", t = "nagaram";
        System.out.println("Brute Force:"+s.isAnagramBruteForce(ss, t));
        System.out.println("Optimal:"+s.isAnagramOptimal(ss, t));
    }
}
