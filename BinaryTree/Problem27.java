//Problem:https://leetcode.com/problems/binary-tree-inorder-traversal/description/
import java.util.*;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    TreeNode cur = root;
    List<Integer> ans = new ArrayList<>();
    while(cur != null){
        //If there is no left
        if(cur.left == null){
            ans.add(cur.val);
            cur=cur.right;
        }
        else{
            //If left present creating the thread/path between  prev right most to root 
            TreeNode prev = cur.left;
        while(prev.right != null && prev.right != cur)
            prev=prev.right;
        if(prev.right == null){
            prev.right=cur;
            cur=cur.left;
        }
        else
        {   prev.left=null;
            ans.add(cur.val);
            cur=cur.right;
        }
        
        }
    }
    return ans;
    }
     public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      TreeNode cur = root;
      while( cur !=null){
        if(cur.left ==null){
            ans.add(cur.val);
            cur=cur.right;
        }
        else{
            TreeNode prev = cur.left;
            while(prev.right != null && prev.right != cur)
                prev=prev.right;
            if(prev.right == null)
            {
                prev.right = cur;
                //Only here changed if u traverse u can understand why
                ans.add(cur.val);
                cur = cur.left;
            }
            else{
                prev.right = null;
                cur=cur.right;
            }
        }
      }
      return ans;
    }
    }
public class Problem27 {
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

        Solution s = new Solution();
        System.out.println("Morris Traversal:"+s.inorderTraversal(root));
      
    }
}
