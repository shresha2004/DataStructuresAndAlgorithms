 //Problem:https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            insertNode(root,preorder[i]);
        }
        return root;
    }
    private void insertNode(TreeNode root,int data){
        if(root.val > data && root.left == null){
            TreeNode newNode = new TreeNode(data);
            root.left = newNode;
            return;
        }
        if(root.val <data && root.right == null){
            TreeNode newNode = new TreeNode(data);
            root.right = newNode;
            return;
        }
        if(root.val > data)  insertNode(root.left,data);
        else  insertNode(root.right,data);


    }
}

public class Problem9 {
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
        System.out.println("Solution:"+s.bstFromPreorder(arr).val);
      
    }
}
