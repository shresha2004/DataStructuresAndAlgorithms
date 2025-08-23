//Problem:https://leetcode.com/problems/assign-cookies/description/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        quickSort(g,0,g.length-1);
        quickSort(s,0,s.length-1);
        int child =0;
        int cookies = 0;
        while(child < g.length && cookies < s.length){
           if(g[child]<=s[cookies]){
            child++;
            cookies++;
           }else{
            cookies++;
           }
        }
        return child;
    }

    public void quickSort(int[] nums, int low, int high){
        if(low <= high){
            int p = partition(nums,low,high);
            quickSort(nums,low,p-1);
            quickSort(nums,p+1,high);
        }
    }
    private int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        int i =low+1;
        int j=high;
        while(i<=j){
            while(i<=high &&  nums[i]<= pivot) i++;
            while( j>=low && nums[j]> pivot) j--;
            if(i<j){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp = nums[j];
        nums[j]=nums[low];
        nums[low]=temp;
        return j;
    }
}
public class Problem70 {
    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        Solution ss = new Solution();
        System.out.println("Solution:"+ss.findContentChildren(g, s));
    }
}
