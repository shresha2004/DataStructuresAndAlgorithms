 //Problem:https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
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
class Pair{
    Node node;
    int line;
    Pair(Node node,int line){
        this.node = node;
        this.line = line;
    }
}    
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
    ArrayList<Integer> ans = new ArrayList<>();
    if(root == null) return ans;
     Map<Integer,Integer> map = new TreeMap<>();
     Queue<Pair> q = new LinkedList<>();
     q.offer(new Pair(root,0));
     
     while(!q.isEmpty()){
         Pair curBox = q.poll();
         int line = curBox.line;
         Node node = curBox.node;
         
         if(map.get(line)==null) map.put(line,node.data);
         if(node.left != null){
             q.offer(new Pair(node.left,line-1));
         }
         if(node.right != null){
             q.offer(new Pair(node.right,line+1));
         }
     }
     for(Map.Entry<Integer,Integer> entry : map.entrySet())
        ans.add(entry.getValue());
        
        
        return ans;
     
    }
}

public class Problem12 {
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
  System.out.println("Solution:"+sol.topView(root));
      
    }
}
