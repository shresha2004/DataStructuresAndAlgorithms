//Problem:https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

import java.util.*;
 class BSTIterator{
    boolean reverse;
    Stack<TreeNode> st = new Stack<>();
    BSTIterator(TreeNode root,boolean reverse){
        this.reverse = reverse;
        pushAll(root);
    }
    public int next(){
        TreeNode node = st.pop();
        //Inorder
        if(!reverse) pushAll(node.left);
        
        else pushAll(node.right);
        return node.val;
    }
    public boolean hasNext(){
        return !st.isEmpty();
    }
    public void pushAll(TreeNode node){
        while(node != null){
            st.push(node);
            if(reverse) node=node.left;
            else node = node.right;
        }
    }
 }
class Solution {
    public boolean findTargetBruteForce(TreeNode root, int k) {
      ArrayList<Integer> arr = new ArrayList<>();
       inorder(root,arr);
       int left = 0;
       int right = arr.size()-1;
       while(left < right){
        int sum = arr.get(left)+arr.get(right);
        if(sum == k) return true;
        if(sum > k) right--;
        else left++;
       }
       return false;
    }
    private void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root == null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
     public boolean findTargetoptimal(TreeNode root, int k) {
     BSTIterator l = new BSTIterator(root,true);
     BSTIterator r = new BSTIterator(root,false);

     int left = l.next();
     int right = r.next();
     while(left < right){
        int sum = left + right;
        if(sum == k) return true;
        if(sum > k) right = r.next();
        else left = l.next();
     }
     return false;
    }
}



public class Problem12 { public static TreeNode createBST(int[] arr) {
    if (arr.length == 0) return null;
    TreeNode root = null;
    for (int val : arr) {
        root = insertIntoBST(root, val);
    }
    return root;
}

private static TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }
    if (val < root.val) {
        root.left = insertIntoBST(root.left, val);
    } else {
        root.right = insertIntoBST(root.right, val);
    }
    return root;
}
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7}; 
        TreeNode root = createBST(arr); 

        Solution s = new Solution();
        System.out.println("Brute Force:"+s.findTargetBruteForce(root, 5));
        System.out.println("Optimal:"+s.findTargetoptimal(root, 5));
    }
}
