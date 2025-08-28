 //Problem:https://leetcode.com/problems/symmetric-tree/description/
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
      return checkMirror( root.left,root.right);
    }

    private boolean checkMirror(TreeNode node1,TreeNode node2){
       if(node1 == null && node2== null)  return true;
       if(node1 == null || node2 == null) return false;
     
     return (node1.val == node2.val) && checkMirror(node1.left,node2.right) && checkMirror(node1.right ,node2.left);
    }
}

public class Problem15 {
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

        Solution s = new Solution();
        System.out.println("Solution:"+s.isSymmetric(root));
      
    }
}
