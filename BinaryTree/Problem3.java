            
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
     public List<Integer> postorderTraversalLoop(TreeNode root) {
       Stack<TreeNode> st1 = new Stack<>();
       Stack<TreeNode> st2 = new Stack<>();
       List<Integer> ans = new ArrayList<>();
       if(root== null) return ans;
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode  node= st1.pop();
            st2.push(node);
            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }
        while(!st2.isEmpty()) ans.add(st2.pop().val);
        return ans;
    }
    public List<Integer> postorderTraversalRecusrsive(TreeNode root) {
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

    public List<Integer> postorderTraversalSingleStack(TreeNode root) {
      TreeNode curr = root;
      Stack<TreeNode> st = new Stack<>();

     List<Integer> ans = new ArrayList<>();
             if(root == null) return ans;

      while(curr != null || !st.isEmpty()){
        if(curr != null){
            st.push(curr);
            curr = curr.left;
        }
        else{
            TreeNode temp = st.peek().right;
            if(temp == null){
                temp = st.peek();
                st.pop();
                ans.add(temp.val);
                while(!st.isEmpty() && temp ==st.peek().right){
                        
                        temp = st.peek();
                        st.pop();
                        ans.add(temp.val);
                }

            }
            else {
                curr=temp;
            }
        }
      }
      return ans;
    }
}

public class Problem3 {
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
        System.out.println("Using Iteration:"+sol.postorderTraversalLoop(root));
        System.out.println("Using Recursion:"+sol.postorderTraversalRecusrsive(root));
        System.out.println("Using Single Stack:"+sol.postorderTraversalSingleStack(root));
        
}
}
