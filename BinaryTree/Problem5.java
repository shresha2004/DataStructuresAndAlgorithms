 //Problem:
 import java.util.*; 
   class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
class Pair<Node,Num>{
    Node node;
    Num num;
    Pair(Node node, Num num){
        this.node = node;
        this.num = num;
    }
}    
class Solution {
   public void completeTraversal(TreeNode root){
    Stack<Pair<TreeNode,Integer>> st = new Stack<>();
    List<Integer> preOrder = new ArrayList<>();
    List<Integer> inOrder = new ArrayList<>();
    List<Integer> postOrder = new ArrayList<>();
    st.push(new Pair<>(root, 1));

    while(!st.isEmpty()){
       Pair<TreeNode,Integer> it = st.pop();

       if(it.num == 1){
        preOrder.add(it.node.val);
        it.num++;
        st.push(it);
        if(it.node.left != null){
            st.push(new Pair<>(it.node.left,1));
        }
    }
        else if(it.num == 2){
            inOrder.add(it.node.val);
            it.num++;
            st.push(it);
            if(it.node.right != null){
                st.push(new Pair<>(it.node.right,1));
            }
        }
        else{
            postOrder.add(it.node.val);
        }
       }
    
    System.out.println("PreOrder:"+preOrder);
    System.out.println("InOrder:"+inOrder);
    System.out.println("PostOrder:"+postOrder);
   }
}

public class Problem5 {
     public static TreeNode createTree(int[] arr) {
        if (arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode current = q.poll();

            if (i < arr.length) {
                current.left = new TreeNode(arr[i++]);
                q.offer(current.left);
            }
            if (i < arr.length) {
                current.right = new TreeNode(arr[i++]);
                q.offer(current.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
        TreeNode root = createTree(arr); 

        Solution sol = new Solution();
        sol.completeTraversal(root);

      
    }
}
