         
//Problem:https://leetcode.com/problems/binary-tree-inorder-traversal/description/
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
    public List<Integer> inorderTraversalLoop(TreeNode root) {
      Stack<TreeNode> st = new Stack<>();
       List<Integer> ans = new ArrayList<>() ;
        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;
                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return traverse(root,ans);
    }
    private List<Integer> traverse(TreeNode node,List<Integer> ans){
        if(node == null) return ans;
        traverse(node.left,ans);
        ans.add(node.val);
        traverse(node.right,ans);
        return ans;
    }
}

public class Problem2 {
    
}
