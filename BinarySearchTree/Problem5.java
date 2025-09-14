
//Problem:https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode node = root;
        while (node.left != null || node.right != null) {
            if (node.val > val && node.left == null) {
                TreeNode newNode = new TreeNode(val);
                node.left = newNode;
                return root;
            }
            if (node.val < val && node.right == null) {
                TreeNode newNode = new TreeNode(val);
                node.right = newNode;
                return root;
            }
            if (node.val < val) {
                node = node.right;
            } else
                node = node.left;
        }
        TreeNode newNode = new TreeNode(val);
        if (node.val > val) {
            node.left = newNode;
        } else
            node.right = newNode;
        return root;
    }
}

public class Problem5 {
    public static TreeNode createBST(int[] arr) {
        if (arr.length == 0)
            return null;
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
        int[] arr = { 1, 2, 3, 4, 25, 6, 7 };
        TreeNode root = createBST(arr);

        Solution s = new Solution();
        System.out.println("Solution:"+s.insertIntoBST(root, 20).val);
    }
}
