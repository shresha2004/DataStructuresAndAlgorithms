         
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
    public static TreeNode createTree(int[] arr) {
        if (arr.length == 0) return null;
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
     int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
        TreeNode root = createTree(arr); 

        Solution sol = new Solution();
        System.out.println("Using Iteration:"+sol.inorderTraversalLoop(root));
        System.out.println("Using Recursion:"+sol.inorderTraversalRecursive(root));
}
}
