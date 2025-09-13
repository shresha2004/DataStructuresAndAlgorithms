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
    public static int floor(Node root, int x) {
        // Code here
        Node node = root;
        int floor = -1;
        while(node != null){
            if(node.data <= x){
                floor = node.data;
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
        return floor;
    }
}

public class Problem4 {
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
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
        Node root = createBST(arr); 

        Solution s = new Solution();

        System.out.println("Solution:"+s.floor(root, 90));
    }
}
