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

        System.out.println("Preorder Iterative: " + sol.preorderTraversalUsingLoop(root));
        System.out.println("Preorder Recursive: " + sol.preorderTraversalUsingRecu(root));
    }
}
