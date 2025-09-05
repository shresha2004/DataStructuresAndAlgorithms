 //Problem:https://leetcode.com/problems/search-in-a-binary-search-tree/description/
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
    public TreeNode searchBSTBruteForce(TreeNode root, int val) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curNode = q.poll();
            if(curNode.val == val) return curNode;
            if(curNode.left != null) q.offer(curNode.left);
            if(curNode.right != null) q.offer(curNode.right);
        }
        return null;
    }

      public TreeNode searchBSTBetter(TreeNode root, int val) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curNode = q.poll();
            if(curNode.val == val) return curNode;
            if(curNode.left != null && val<curNode.val) q.offer(curNode.left);
            else if(curNode.right != null && val>curNode.val) q.offer(curNode.right);
        }
        return null;
    }

     public TreeNode searchBSTOptimal(TreeNode root, int val) {
       while( root != null && root.val != val)
            root = (val < root.val)? root.left : root.right;
      return root;
    }
}

public class Problem1 {
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
        int val = 7;
        Solution s = new Solution();
        System.out.println("My Brute Force:"+s.searchBSTBruteForce(root, val).val);
        System.out.println("My Better:"+s.searchBSTBetter(root, val).val);
        System.out.println("Optimal:"+s.searchBSTOptimal(root, val).val);
      
    }
}
