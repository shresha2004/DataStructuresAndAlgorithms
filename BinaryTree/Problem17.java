 //Problem:
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null || root==p || root == q) return root;
      TreeNode left = lowestCommonAncestor(root.left,p,q);
      TreeNode right = lowestCommonAncestor(root.right,p,q);
      if(left == null) return right;
     else if(right == null) return left;
      else return root;
    }
}

public class Problem17 {
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
        System.out.println("Solution:"+s.lowestCommonAncestor(root, root.left.left, root.right.right).val);
      
    }
}
