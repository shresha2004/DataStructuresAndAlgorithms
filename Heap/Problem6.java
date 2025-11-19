 //Problem:https://www.geeksforgeeks.org/problems/bst-to-max-heap/1
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
    public static Node convertToMaxHeapUtil(Node root) {
        // code here
        ArrayList<Integer> inorder = new ArrayList<>();
        //Why inorder traversal?
        //Gives Array eles in sorted order
        inorderTraversal(root,inorder);
        int[] index = new int[1];
        //Why postorder to reassign?
        //Because it assigns first both child and then parent 
        //Child shd be minimum then parent
        postorderTraversal(root,inorder,index);
        return root;
    }
    private static void inorderTraversal(Node root,ArrayList<Integer> inorder){
        if(root == null) return;
        inorderTraversal(root.left,inorder);
        inorder.add(root.data);
        inorderTraversal(root.right,inorder);
        
    }
    private static void postorderTraversal(Node root,ArrayList<Integer> inorder,int[] index){
        if(root == null) return;
        postorderTraversal(root.left,inorder,index);
        postorderTraversal(root.right,inorder,index);
        root.data = inorder.get(index[0]);
        index[0]=index[0]+1;

    }
}

public class Problem6 {
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
        System.out.println("Converting BST to Max heap:"+s.convertToMaxHeapUtil(root).data);
      
    }
}
