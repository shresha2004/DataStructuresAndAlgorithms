
//Problem:https://leetcode.com/problems/count-complete-tree-nodes/description/?envType=problem-list-v2&envId=binary-tree
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int countNodesBruteForce(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();
            count++;
            if (curNode.left != null)
                q.offer(curNode.left);
            if (curNode.right != null)
                q.offer(curNode.right);
        }
        return count;
    }
      public int countNodesBetter(TreeNode root) {
       if(root == null)  return 0;
        return 1+(countNodesBetter(root.left))+(countNodesBetter(root.right));
    }
     public int countNodesOptimal(TreeNode root) {
       if(root == null)  return 0;
       int lH = findLeftHeight(root);
       int rH = findRightHeight(root);
       if(lH == rH) return (1<<lH)-1;
        return 1+(countNodesOptimal(root.left))+(countNodesOptimal(root.right));
    }
    private int findLeftHeight(TreeNode root){
       int height = 0;
        while(root != null){
            height++;
            root=root.left;
        }
        return height;
    }
    private int findRightHeight(TreeNode root){
      int  height = 0;
        while(root != null){
            height++;
            root=root.right;
        }
        return height;
    }
}

public class Problem23 {
    public static TreeNode createTree(int[] arr) {
        if (arr.length == 0)
            return null;
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
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = createTree(arr);

        Solution s = new Solution();
        System.out.println("Brute Force:" + s.countNodesBruteForce(root));
        System.out.println("Better"+s.countNodesBetter(root));
        System.out.println("Optimal:"+s.countNodesOptimal(root));

    }
}
