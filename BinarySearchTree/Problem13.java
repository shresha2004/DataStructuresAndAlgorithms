 //Problem:https://leetcode.com/problems/recover-binary-search-tree/description/
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
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;
    public TreeNode recoverTree(TreeNode root) {
        first=middle=last=null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first !=null && last != null){
            swap(first,last);
        }
        else swap(first,middle);
        return root;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        if(prev.val != Integer.MIN_VALUE &&  root.val < prev.val){
            if(first == null){
                first = prev;
                middle = root;
            }
            else{
                last=root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    private void swap(TreeNode node1,TreeNode node2){
        if(node1 != null && node2 != null){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        }
    }
}

public class Problem13 {
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
        int[] arr = {1, 2, 55, 4, 5, 6, 7}; 
        TreeNode root = createBST(arr); 

        Solution s = new Solution();
        System.out.println("Solution:"+s.recoverTree(root).val);
      
    }
}


