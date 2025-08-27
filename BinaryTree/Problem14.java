 //Problem:https://leetcode.com/problems/binary-tree-right-side-view/description/
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
    int row;
    TreeNode node;
    Pair(int row,TreeNode node){
        this.row=row;
        this.node= node;
    }
}
    
class Solution {
    public List<Integer> rightSideViewBruteForce(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int row = cur.row;
            TreeNode nd = cur.node;
            map.put(row,nd.val);
            if(nd.left != null) q.offer(new Pair(row+1,nd.left));
            if(nd.right != null) q.offer(new Pair(row+1,nd.right));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public List<Integer> rightSideViewOptimal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        traverse(root,0,ans);
        return ans;
    }
    private void traverse(TreeNode node,int level,ArrayList<Integer> ans){
        if(node == null) return;
        if(ans.size() == level) ans.add(node.val);
        if(node.right != null ) traverse(node.right,level+1,ans);
        if(node.left != null) traverse(node.left,level+1,ans);
        return;
    }
}

public class Problem14 {
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
        System.out.println("BruteForce:"+s.rightSideViewBruteForce(root));
        System.out.println("Optimal:"+s.rightSideViewOptimal(root));

      
    }
}
