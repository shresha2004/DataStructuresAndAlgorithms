 //Problem:https://leetcode.com/problems/validate-binary-search-tree/description/
 import java.util.*; 
   class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    
class Solution {
    public boolean isValidBST(TreeNode root) {
       return checkValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean checkValid(TreeNode node,long minValue,long maxValue){
        if(node == null) return true;
        if(node.val >= maxValue || node.val <= minValue) return false;
        return checkValid(node.left,minValue,node.val) && checkValid(node.right,node.val,maxValue);
    }
}

public class Problem7 {
     public static TreeNode createBST(int[] arr) {
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
        System.out.println("Solution:"+s.isValidBST(root));

      
    }
}
