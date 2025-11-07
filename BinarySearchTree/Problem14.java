 //Problem:https://www.geeksforgeeks.org/problems/largest-bst/1
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
class NodeValue{
    int minNode;
    int maxNode;
    int maxLen;
    NodeValue(int minNode,int maxNode,int maxLen){
        this.minNode=minNode;
        this.maxNode=maxNode;
        this.maxLen=maxLen;
    }
}
class Solution {
    static int largestBst(Node root) {
        // Write your code here
        return postorder(root).maxLen;
   
    }
    static NodeValue postorder(Node root){
        if(root == null) return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        
        NodeValue left = postorder(root.left);
        NodeValue right = postorder(root.right);
        
        if(left.maxNode < root.data && right.minNode > root.data){
            return new NodeValue(Math.min(root.data,left.minNode),Math.max(root.data,right.maxNode),left.maxLen+right.maxLen+1);
        }
        
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxLen,right.maxLen));
    }
}

public class Problem14 {
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
        System.out.println("Solution:"+s.largestBst(root));
      
    }
}


