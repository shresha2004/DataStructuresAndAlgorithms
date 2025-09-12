 //Problem:https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
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
   int findCeil(Node root, int x) {
        // code here
     Node node = root;
     int ceil  = -1;
     while(node != null){
         if(node.data > x){
             ceil = node.data;
             node = node.left;
         }
         else if(node.data < x ){
             node = node.right;
         }
         else return node.data;
     }
     return ceil;
    }
}

public class Problem3 {
     public static Node createBST(int[] arr) {
    if (arr.length == 0) return null;
    Node root = null;
    for (int data : arr) {
        root = insertIntoBST(root, data);
    }
    return root;
}

private static Node insertIntoBST(Node root, int data) {
    if (root == null) {
        return new Node(data);
    }
    if (data < root.data) {
        root.left = insertIntoBST(root.left, data);
    } else {
        root.right = insertIntoBST(root.right, data);
    }
    return root;
}
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 6, 7}; 
        Node root = createBST(arr); 

        Solution s = new Solution();
        System.out.println("Solution:"+s.findCeil(root, 5));
      
    }
}
