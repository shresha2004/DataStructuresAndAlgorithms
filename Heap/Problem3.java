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
    public boolean isHeap(Node tree) {
        // code here
        boolean isMaxHeap = isMaxHeap(tree);
        int total = totalCount(tree);
        boolean isCBT = checkCBT(tree,total,0);
        return isMaxHeap && isCBT;
    }
    private boolean isMaxHeap(Node root){
        if(root == null) return true;
        if((root.left != null && root.left.data > root.data )|| (root.right!= null && root.right.data>root.data)) return false;
        return isMaxHeap(root.left) && isMaxHeap(root.right);
    }
    private int totalCount(Node root){
        if(root == null) return 0;
        return 1+totalCount(root.left)+totalCount(root.right);
    }
    private boolean checkCBT(Node root,int total,int index){
        if(root == null) return true;
        if(index >= total) return false;
        boolean left = checkCBT(root.left,total,2*index+1);
        boolean right = checkCBT(root.right,total,2*index+2);
        return left && right;
    }
}

public class Problem3 {
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
        int[] arr = {97, 46, 37, 12, 3, 7, 31, 6, 9};
        Node root = createTree(arr); 

        Solution s = new Solution();
        System.out.println("Check max heap:"+s.isHeap(root));

      
    }
}
