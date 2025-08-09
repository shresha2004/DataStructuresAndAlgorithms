//Problem:https://leetcode.com/problems/binary-tree-level-order-traversal/description/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
                if(root == null) return ans;

        qu.offer(root);

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            ArrayList<Integer> subList = new ArrayList<>();
            for(int i=0;i<levelNum;i++){
                TreeNode node = qu.poll();
                subList.add(node.val);
                if(  node.left != null) qu.offer(node.left);
                if( node.right != null) qu.offer(node.right);
                
                
            }
            ans.add(subList);
        }
        return ans;
    }
     
}
public class Problem4 {
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
        System.out.println("Level Order:"+sol.levelOrder(root));
       
        
}
}
