//Problem:https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
import java.util.ArrayList;
class Solution {
    public boolean findTarget(TreeNode root, int k) {
      ArrayList<Integer> arr = new ArrayList<>();
       inorder(root,arr);
       int left = 0;
       int right = arr.size()-1;
       while(left < right){
        int sum = arr.get(left)+arr.get(right);
        if(sum == k) return true;
        if(sum > k) right--;
        else left++;
       }
       return false;
    }
    private void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root == null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}



public class Problem12 { public static TreeNode createBST(int[] arr) {
    if (arr.length == 0) return null;
    TreeNode root = null;
    for (int val : arr) {
        root = insertIntoBST(root, val);
    }
    return root;
}

private static TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    if (val < root.val) {
        root.left = insertIntoBST(root.left, val);
    } else {
        root.right = insertIntoBST(root.right, val);
    }
    return root;
}
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
        TreeNode root = createBST(arr); 

        Solution s = new Solution();
        System.out.println("Brute Force:"+s.findTarget(root, 5));
    }
}
