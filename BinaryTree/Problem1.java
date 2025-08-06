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
    public List<Integer> preorderTraversalUsingLoop(TreeNode root) {
       Stack<TreeNode> st = new Stack<>();
       List<Integer> ans = new ArrayList<>();
       if(root == null) return ans;
       TreeNode node = root;
       st.push(node);
        while(!st.isEmpty()){
           node = st.peek();
           st.pop();
           ans.add(node.val);
           if(node.right != null) st.push(node.right);
           if(node.left != null) st.push(node.left);
        }
        return ans;
    }
    public List<Integer> preorderTraversalUsingRecu(TreeNode root) {
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
