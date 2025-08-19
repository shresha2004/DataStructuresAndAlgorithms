 //Problem:
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
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        if(node == null) return null;
        ArrayList<Integer> ans = new ArrayList<>();
        if(!isLeaf(node)) ans.add(node.data);
        addLeft(node.left,ans);
        addLeaf(node,ans);
        addRight(node.right,ans);
        return ans;
    }
    private void addLeft(Node node,ArrayList<Integer> ans){
        Node cur = node;
        while(cur != null){
           if(!isLeaf(cur)) ans.add(cur.data);
            if(cur.left != null) cur = cur.left;
            else cur =cur.right;
        }
    }
    private void addLeaf(Node node, ArrayList<Integer> ans){
        if(node == null) return;
        addLeaf(node.left,ans);
        if(isLeaf(node)) ans.add(node.data);
        addLeaf(node.right,ans);
        
    }
    private void addRight(Node node,ArrayList<Integer> ans){
        if(node == null) return;
        Node cur = node;
        ArrayList<Integer> temp = new ArrayList<>();
        while(cur != null){
           if(!isLeaf(cur)) temp.add(cur.data);
            if(cur.right != null) cur = cur.right;
            else cur= cur.left;
        }
        for(int i= temp.size()-1;i>=0;i--)
            ans.add(temp.get(i));
    }
    private boolean isLeaf(Node node){
        if(node.left == null && node.right == null) return true;
        return false;
    }
}

public class Problem11 {
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

        Solution sol = new Solution();
        System.out.println("Border Traversal:"+sol.boundaryTraversal(root));

      
    }
}

