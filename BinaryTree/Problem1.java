 //Problem:https://leetcode.com/problems/binary-tree-preorder-traversal/
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return traverse(root,list);
    }
    private List<Integer> traverse(TreeNode node,List<Integer> list){
        if(node == null){
            return list;
        }
        list.add(node.val);
        traverse(node.left,list);
        traverse(node.right,list);
        return list;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        
    }
}
