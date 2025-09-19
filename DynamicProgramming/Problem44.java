//Problem:https://leetcode.com/problems/largest-divisible-subset/description/
import java.util.*;
class Solution{
public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        quickSort(nums,0,n-1);
        ArrayList<Integer> ans = new ArrayList<>();
        int[] maxLen =new int[n];
        Arrays.fill(maxLen,1);
        int[] hash = new int[n];
        for(int i=0;i<n;i++) hash[i]=i;

        for(int i=0;i<n;i++){
            for(int prev =0;prev<i;prev++){
                if((nums[i]%nums[prev]==0 || nums[prev]%nums[i]==0) && (1+maxLen[prev]>maxLen[i])){
                    maxLen[i]=1+maxLen[prev];
                    hash[i]=prev;
                }
            }
        }
        int maxLength = 0;
        int maxInd = 0;
        for(int i=0;i<n;i++){
            if(maxLen[i]>maxLength){
                maxLength = maxLen[i];
                maxInd = i;
            }
        }
        while(ans.size() != maxLength){
            ans.add(nums[maxInd]);
            maxInd =hash[maxInd];
        }

        return ans;
        
    }
    private void quickSort(int[] nums,int start,int end){
        if(start <= end){
            int p = partition(nums,start,end);
            quickSort(nums,start,p-1);
            quickSort(nums,p+1,end);
        }
    }
    private int partition(int[] nums,int start , int end){
        int pivot = nums[start];
        int i = start+1;
        int j = end;
        while(i <= j){
            if(i<= end && nums[i]<= pivot) i++;
            if(j >= start && nums[j]>= pivot) j--;
            if(i<j){
                int temp = nums[i];
                nums[i]= nums[j];
                nums[j]=temp;
            }
        }
        int temp = nums[start];
        nums[start]=nums[j];
        nums[j]=temp;
        return j;
    }
}
public class Problem44 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums ={6,3,4,8,12,15};
        System.out.println("Solution:"+s.largestDivisibleSubset(nums));        

        
    }
}
