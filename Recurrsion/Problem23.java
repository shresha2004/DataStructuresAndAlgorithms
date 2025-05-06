//Problem:https://www.geeksforgeeks.org/problems/subset-sums2234/1

import java.util.ArrayList;
import java.util.List;

class Solution{
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
       backtrack(ans,arr,0,0);
       return ans;
    }
    private void backtrack(List<Integer> ans,int[] arr,int sum,int index){
        if(index == arr.length){
            ans.add(sum);
            return;
        }
        backtrack(ans,arr,sum+arr[index],index+1);
        backtrack(ans,arr,sum,index+1);
        return;
    }
}
public class Problem23 {
    public static void main(String[] args) {
        int[] arr ={ 2, 3};
        Solution s = new Solution();
        System.out.println("Recursive:"+s.subsetSums(arr));
    }
}
