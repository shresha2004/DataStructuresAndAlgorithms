 //Problem:https://leetcode.com/problems/balanced-binary-tree/description/
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
         return (checkBalance(root)== -1)? false : true;
    }
    private int checkBalance(TreeNode root){
        if(root == null) return 0;
        int left = checkBalance(root.left);
        if(left == -1) return -1;
        int right = checkBalance(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return 1+Math.max(left,right);
    }
}

public class Problem7 {
     public static TreeNode createTree(int[] arr) {
        if (arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode current = q.poll();

            if (i < arr.length) {
                current.left = new TreeNode(arr[i++]);
                q.offer(current.left);
            }
            if (i < arr.length) {
                current.right = new TreeNode(arr[i++]);
                q.offer(current.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
        TreeNode root = createTree(arr); 

        Solution sol = new Solution();
        System.out.println("Solution:"+sol.isBalanced(root));
      
    }
}
