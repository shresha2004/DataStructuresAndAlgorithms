 //Problem:https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
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
   int postInd;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       if(inorder.length != postorder.length) return null;
       int n = inorder.length;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<n;i++) map.put(inorder[i],i);
       postInd=n-1;
       return  helper(map,postorder,0,n-1);
    }
    private TreeNode helper(HashMap<Integer,Integer> map , int[] postorder,int left,int right){
        if(left > right) return null;
        int rootVal = postorder[ postInd];
       postInd--;
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
                root.right = helper(map,postorder,mid+1,right);

        root.left=helper(map,postorder,left,mid-1);
        return root;
    }
}

public class Problem25 {
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
        int[] Inorder= {9, 3, 15, 20, 7};
int[] Postorder= {9, 15, 7, 20, 3};
        
        Solution s = new Solution();
        System.out.println("Solution:"+s.buildTree(Inorder,Postorder).val);
      
    }
}
