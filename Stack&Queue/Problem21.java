//Problem:https://leetcode.com/problems/largest-rectangle-in-histogram/description
import java.util.Stack;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = findNSE(heights,n);
        int[] pse = findPSE(heights,n);
        int max =0;
        for(int i=0;i<n;i++){
            max = Math.max(max,(heights[i]*(nse[i]-pse[i]-1)));
        }

        return max;
    }
    private int[] findNSE(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) nse[i]=n;
            else nse[i]= st.peek();
            st.push(i);
        }
    return nse;
    }

    private int[] findPSE(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();

            if(st.isEmpty()) pse[i]=-1;
            else pse[i] =st.peek();
            st.push(i);
        }
        return pse;
    }
}
public class Problem21 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] heights ={2,1,5,6,2,3};
        System.out.println("Brute Force:"+s.largestRectangleArea(heights));

    }
}
