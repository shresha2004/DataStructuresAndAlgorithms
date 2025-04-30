
//Problem:https://www.geeksforgeeks.org/problems/sort-a-stack/0
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    public Stack<Integer> sortBruteForce(Stack<Integer> s) {
        // add code here.
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> ans = new Stack<>();
        while (!s.isEmpty()) {
            arr.add(s.pop());
        }
        quickSort(arr, 0, arr.size() - 1);
        for (int ele : arr) {
            ans.push(ele);
        }
        return ans;
    }

    private void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;
        while (i <= j) {
            while (i <= high && arr.get(i) <= pivot)
                i++;
            while (j >= low && arr.get(j) > pivot)
                j--;
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int t = arr.get(j);
        arr.set(j, pivot);
        arr.set(low, t);
        return j;
    }
    public Stack<Integer> sortOptimal(Stack<Integer> s) {
        // add code here.
        if(!s.isEmpty()){
            int temp = s.pop();
            sortOptimal(s);
            insertSorted(s,temp);
        }
        return s;
    }
    public void insertSorted(Stack<Integer> s,int ele){
        if(s.isEmpty() || ele > s.peek()) s.push(ele);
        else{
            int temp = s.pop();
            insertSorted(s,ele);
            s.push(temp);
        }
    }
}

public class Problem16 {
    public static void main(String[] args) {
        int[] arr ={ 11 ,2, 32 ,3 ,41};
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int ele: arr){
            stack1.push(ele);
        }
        for(int ele: arr){
            stack2.push(ele);
        }
        Solution s = new Solution();
        System.out.println("Brute Force:"+s.sortBruteForce(stack1));
        System.out.println("Optimal:"+s.sortOptimal(stack2));
    }
}
