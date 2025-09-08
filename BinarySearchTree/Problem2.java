 //Problem:https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/?envType=problem-list-v2&envId=binary-search-tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
       return insertToBST(nums,0,nums.length-1);
    }

    private TreeNode insertToBST(int[] nums,int left, int right){
        if(left > right) return null;
      int mid = (left + right)/2;
      TreeNode node = new TreeNode(nums[mid]);
      node.left = insertToBST(nums,left,mid-1);
      node.right = insertToBST(nums,mid+1,right);
        return node;
    }
}

public class Problem2 {
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
       // TreeNode root = createBST(arr); 

        Solution s = new Solution();
        System.out.println("Solution:"+s.sortedArrayToBST(arr).val);
      
    }
}
