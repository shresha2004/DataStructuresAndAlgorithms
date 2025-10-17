 //Problem:https://www.geeksforgeeks.org/problems/burning-tree/1
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
   public int minTime(Node root, int target) {
        // code here
        HashMap<Node,Node> parent = new HashMap<>();
        HashMap<Node,Boolean> isVis = new HashMap<>();
        Node[] targetAdd = new Node[1];
        bfs(root,target,parent,targetAdd);
        
        Queue<Node> q = new LinkedList<>();
        q.offer(targetAdd[0]);
        isVis.put(targetAdd[0],true);
        int time = 0;
    while(!q.isEmpty()){
        int size = q.size();
        boolean burn = false;
        
        for(int i=0;i<size;i++){
            Node cur = q.poll();
            
            if(cur.left != null && !isVis.containsKey(cur.left)){
                burn = true;
                q.offer(cur.left);
                isVis.put(cur.left,true);
            }
            if(cur.right !=null && !isVis.containsKey(cur.right)){
                burn = true;
                q.offer(cur.right);
                isVis.put(cur.right,true);
                
            }
            
            if(parent.containsKey(cur) && !isVis.containsKey(parent.get(cur))){
                burn = true;
                q.offer(parent.get(cur));
                isVis.put(parent.get(cur),true);
                
            }
        }
        if(burn) time+=1;
        
    }
    return time;
    }
    
    private void bfs(Node root,int target,HashMap<Node,Node> parent,Node[] targetAdd){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.data == target){
                targetAdd[0]=cur;
            }
            if(cur.left != null){
                q.offer(cur.left);
                parent.put(cur.left,cur);
            }
            if(cur.right != null ){
                q.offer(cur.right);
                parent.put(cur.right,cur);
            }
        }
    }
}

public class Problem24 {
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
        System.out.println("Solution:"+s.minTime(root, 4));
      
    }
}
