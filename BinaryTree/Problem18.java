 //Problem:https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 
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
     class Pair{
    int num;
    TreeNode node;
    Pair(int num,TreeNode node){
        this.node = node;
        this.num = num;
    }
 }
class Solution {
   public int widthOfBinaryTree(TreeNode root) {
       if(root == null) return 0;
       Queue<Pair> q = new LinkedList<>();
       q.offer(new Pair(0,root));
       int ans =0;
       while(!q.isEmpty()){
        int size = q.size();
        int mmin = q.peek().num;
        int first = 0,last =0;
        for(int i=0;i<size;i++){
            int cur_ind = q.peek().num-mmin;
            TreeNode node = q.poll().node;
            if(i==0) first= cur_ind;
            if(i==size-1) last=cur_ind;
            if(node.left != null){
                q.offer(new Pair(cur_ind*2+1,node.left ));
            }
            if(node.right != null){
                q.offer(new Pair( cur_ind*2+2,node.right));
            }
        }
        ans = Math.max(ans,last-first+1);
       }
       return ans;
    }
}

public class Problem18 {
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
        System.out.println("Solution:"+s.widthOfBinaryTree(root));
      
    }
}

