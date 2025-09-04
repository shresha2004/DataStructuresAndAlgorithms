 //Problem:https://www.naukri.com/code360/problems/childrensumproperty_790723?leftPanelTabValue=PROBLEM
 import java.util.*; 
   class TreeNode {
       int data;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int data) { this.data = data; }
       TreeNode(int data, TreeNode left, TreeNode right) {
           this.data = data;
           this.left = left;
           this.right = right;
       }
   }
    
class Solution {
   public static void changeTree(TreeNode root) {
        // Write your code here.
        if(root == null) return;
        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child+= root.right.data;
        if(child >= root.data){
            root.data = child;
        }
        else{
             if(root.left != null)  root.left.data=root.data;
        if(root.right != null)  root.right.data=root.data;
        }
        changeTree(root.left);
        changeTree(root.right);

        int total=0;
        if(root.left != null) total+=root.left.data;
        if(root.right != null) total += root.right.data;
        if(root.left != null || root.right != null) root.data = total;
    }
}

public class Problem20 {
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
        s.changeTree(root);

      
    }
}
