//Problem:https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list
import java.util.ArrayList;
class Node
{
    int data;
    Node next;
    Node bottom;
    Node(int d) {data = d; next = null; }
}




class Solution {
    Node flattenBruteForce(Node root) {
        // code here
        
        Node mover = root;
        ArrayList<Integer> arr = new ArrayList<>();
        while(mover != null){
            Node temp = mover;
            while(temp != null){
                arr.add(temp.data);
                temp = temp.bottom;
            }
            mover = mover.next;
            
        }
        quickSort(arr,0,arr.size()-1);
        Node head = new Node(arr.get(0));
        mover = head;
        for(int i=1;i<arr.size();i++){
            Node newNode = new Node(arr.get(i));
            mover.bottom = newNode;
            mover = newNode;
        }
        return head;
    }
    private void quickSort(ArrayList<Integer> arr,int low , int high){
        if(low<high){
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
            
        }
        return;
    }
    
    private int partition(ArrayList<Integer> arr,int low ,int high){
        int pivot = arr.get(low);
        int i = low;
        int j= high;
        
        while(i<=j){
            while(i<= high && arr.get(i) <= pivot) i++;
            while(j>= low && arr.get(j) > pivot) j--;
            if(i<j){
                int temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
            
        }
        int temp = arr.get(low);
        arr.set(low,arr.get(j));
        arr.set(j,temp);
        return j;
    }

    Node flattenOptimal(Node root) {
        // code here
       if(root == null || root.next == null) return root;
       Node List1 = flattenOptimal(root.next);
       return mergeList(List1,root);
    }
    private Node mergeList(Node List1, Node List2){
        Node head = new Node(-1);
        Node res = head;
        while(List1 != null && List2 != null){
            if(List1.data < List2.data){
               res.bottom = List1;
               res = res.bottom;
               List1= List1.bottom;
            }
            else{
                res.bottom = List2;
                res =  res.bottom;
                List2 = List2.bottom;
                
            }
            res.next = null;
        }
        while(List1 != null){
            res.bottom = List1;
            res = res.bottom;
            List1 = List1.bottom;
        }
        while(List2 != null){
            res.bottom = List2;
            res = res.bottom;
            List2 = List2.bottom;
        }
        return head.bottom;
    }
   
}

public class Problem32 {
     public static Node addingArrToLL(int arr[]){
        Node head = new  Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover=temp;
        }
        return head;  
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] arr = { };
        //Node head = addingArrToLL(arr);
        System.out.println("Brute Force  and Optimal:(Code is different. Paste solution class in problem link)");
       // System.out.println("Optimal:"+s.);
    }
}