            
//Problem:https://leetcode.com/problems/binary-tree-postorder-traversal/description/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return traverse(root, ans);
    }
    private List<Integer> traverse(TreeNode node,List<Integer> ans){
        if(node == null) return ans;
        traverse(node.left,ans);
        traverse(node.right,ans);
        ans.add(node.val);
        return ans;
    }
}

public class Problem3 {
    
}
