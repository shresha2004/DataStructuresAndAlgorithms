//Problem:https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list
import java.util.ArrayList;
import java.util.Arrays;

class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumMyBruteForce(int target, Node head) {
        // code here
        Node mover1 = head;
        Node mover2 = head.next;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        while(mover1.next != null){
            int pair1 = mover1.data;
            mover2 = mover1.next;
            while(mover2 != null){
                int pair2 = mover2.data;
                if((pair1+pair2)==target){
                    ans.add(new ArrayList<>(Arrays.asList(pair1,pair2)));
                }
                mover2 = mover2.next;
            }
            mover1=mover1.next;
        }
        
        return ans;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumOptimal(int target, Node head) {
        // code here
       Node left = head;
       Node right = head;
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(right.next != null) right = right.next;
        
        while(left.data < right.data){
            int sum = left.data + right.data;
            if(sum == target && left != right){
                ans.add(new ArrayList<>(Arrays.asList(left.data,right.data)));
                right = right.prev;
                left = left.next;
            }
            else if(sum > target) right = right.prev;
            else left = left.next;
        }
       
        return ans;
    }
   
}
public class Problem24 {
     public static Node doublyLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            temp.prev =mover;
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1 , 2 , 4 , 5 , 6 , 8 , 9};
        Node head = doublyLinkedList(arr);
        System.out.println("My Brute Force:"+s.findPairsWithGivenSumMyBruteForce(7, head));
        System.out.println("My Optimal:"+s.findPairsWithGivenSumOptimal(7, head));        
    }
}
