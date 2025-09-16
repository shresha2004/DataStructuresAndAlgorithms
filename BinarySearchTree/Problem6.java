 //Problem:https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        int[] ans = new int[1];
        inOrderTraversal(root,k,count,ans);
        return ans[0];
    }
    private void inOrderTraversal(TreeNode node,int k,int[] count,int ans[]){
        if(node == null) return;
        inOrderTraversal(node.left,k,count,ans);
        count[0]+=1;
        if(count[0] == k) ans[0]=node.val;
        inOrderTraversal(node.right,k,count,ans);
        return;
    }
}

public class Problem6 {
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
        System.out.println("Solution:"+s.kthSmallest(root, 3));
      
    }
}
