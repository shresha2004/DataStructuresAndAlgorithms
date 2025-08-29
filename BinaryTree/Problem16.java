 //Problem:https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
 import java.util.*; 
   class Node {
       int data;
       Node left;
       Node right;
       Node() {}
       Node(int data) { this.data = data; }
       Node(int data, Node left, Node right) {
           this.data = data;
           this.left = left;
           this.right = right;
       }
   }
    
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<Integer> traverse = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findPaths(root,traverse,ans);
        return ans;
    }
    private static void findPaths(Node node,ArrayList<Integer> traverse,ArrayList<ArrayList<Integer>> ans){
        if(node == null) return;
        traverse.add(node.data);
        if(node.left == null && node.right == null) ans.add(new ArrayList<>(traverse));
        else{
        findPaths(node.left,traverse,ans);
        findPaths(node.right,traverse,ans);
        }
        traverse.remove((traverse.size()-1));
        
        return;
    }
}

public class Problem16 {
     public static Node createTree(int[] arr) {
        if (arr.length == 0) return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node current = q.poll();

            if (i < arr.length) {
                current.left = new Node(arr[i++]);
                q.offer(current.left);
            }
            if (i < arr.length) {
                current.right = new Node(arr[i++]);
                q.offer(current.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
        Node root = createTree(arr); 

        Solution s = new Solution();
        System.out.println("Solution:"+s.Paths(root));
      
    }
}
