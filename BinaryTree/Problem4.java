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
     public List<Integer> postorderTraversal(TreeNode root) {
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
public class Problem4 {
    
}
