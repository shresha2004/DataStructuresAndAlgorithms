 //Problem:https://www.geeksforgeeks.org/problems/children-sum-parent/1
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
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null) return false;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curNode = q.poll();
            int leftNum = (curNode.left != null)?curNode.left.data : 0;
            int rightNum = (curNode.right != null)?curNode.right.data :0;
            if(curNode.left != null || curNode.right != null){
                if(curNode.data != (leftNum+rightNum)) return false;
            }
          if(curNode.left != null)  q.offer(curNode.left);
           if(curNode.right != null) q.offer(curNode.right);
        }
        return true;
    }
}

public class Problem19 {
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
        System.out.println("Solution:"+s.isSumProperty(root));
      
    }
}
