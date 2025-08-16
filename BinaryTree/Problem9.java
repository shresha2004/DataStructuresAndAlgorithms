 //Problem:https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] =Integer.MIN_VALUE;
        findPath(root,maxSum);
        return maxSum[0];
    }
    private int findPath(TreeNode node,int[] maxSum){
        if(node == null) return 0;
        int left =Math.max(0, findPath(node.left,maxSum));
        int right =Math.max(0, findPath(node.right,maxSum));
        maxSum[0]=Math.max(maxSum[0],left+right+node.val);

        return node.val+Math.max(left,right);
    }
}


public class Problem9 {
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
        System.out.println("Solution:"+sol.maxPathSum(root));

      
    }
}
