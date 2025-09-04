 //Problem:https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
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
   public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       HashMap<TreeNode,TreeNode> parent = new HashMap<>() ;
       parentTrack(parent,root);
       int curLevel=0;
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       HashMap<TreeNode,Boolean> visited = new HashMap<>();
       q.offer(target);
       visited.put(target,true);
       while(!q.isEmpty()){
        int size = q.size();
        if(curLevel == k) break;
        curLevel++;
        for(int i=0;i<size;i++){
            TreeNode curNode = q.poll();
            if(curNode.left != null && visited.get(curNode.left)== null){
                visited.put(curNode.left,true);
                q.offer(curNode.left);
            }
            if(curNode.right != null && visited.get(curNode.right)==null){
                visited.put(curNode.right,true);
                q.offer(curNode.right);
            }
            if(parent.get(curNode)!= null && visited.get(parent.get(curNode))==null){
                visited.put(parent.get(curNode),true);
                q.offer(parent.get(curNode));
            }
        }
       }
       List<Integer> ans = new ArrayList<>();
       while(!q.isEmpty()){
        ans.add(q.poll().val);
       }
 return ans;

    }
    public void parentTrack(HashMap<TreeNode,TreeNode> parent, TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curNode = q.poll();
            if(curNode.left != null){
                 parent.put(curNode.left,curNode);
                 q.offer(curNode.left);
             }
            if(curNode.right != null){
                 parent.put(curNode.right,curNode);
                 q.offer(curNode.right);
            }

        }
    }
}

public class Problem21 {
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
        System.out.println("Solution:"+s.distanceK(root,root.left.left, 2));
      
    }
}
