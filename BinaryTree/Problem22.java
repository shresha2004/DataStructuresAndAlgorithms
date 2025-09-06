 //Problem:https://www.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1
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
    public static int findMax(Node root) {
        // code here
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node curNode = q.poll();
            max = Math.max(curNode.data,max);
            if(curNode.left != null) q.offer(curNode.left);
            if(curNode.right != null) q.offer(curNode.right);
        }
        return max;
        
    }

    public static int findMin(Node root) {
        
        // code here
         int min = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node curNode = q.poll();
            min = Math.min(curNode.data,min);
            if(curNode.left != null) q.offer(curNode.left);
            if(curNode.right != null) q.offer(curNode.right);
        }
        return min;
        
    }
}

public class Problem22 {
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
        System.out.println("Solution:"+s.findMax(root)+" "+s.findMin(root));
      
    }
}
