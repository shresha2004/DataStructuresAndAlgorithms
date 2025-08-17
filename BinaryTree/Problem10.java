 //Problem:https://leetcode.com/problems/same-tree/description/
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
   public boolean isSameTreeMyLogic(TreeNode p, TreeNode q) {
                if(p==null && q==null) return true;
        return (checkSame(p,q)==1)?true : false;
    }
    private int checkSame(TreeNode p, TreeNode q){
        if(p==null && q== null) return 1;
        if(p==null || q==null || p.val != q.val) return -1;
        int left = checkSame(p.left,q.left);
        int right = checkSame(p.right,q.right);
        return (left == -1 || right == -1)? -1 : 1;

    }
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q== null) return p==q;
       
        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

public class Problem10 {
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
        TreeNode root1 = createTree(arr); 
        TreeNode root2 = createTree(arr); 

        Solution sol = new Solution();
        System.out.println("My Logic:"+sol.isSameTreeMyLogic(root1, root2));
        System.out.println("Solution:"+sol.isSameTree(root1, root2));
      
    }
}
