//Problem:https://leetcode.com/problems/sort-list/description/
import java.util.ArrayList;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode sortListBruteForce(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode mover = head;
        while(mover != null){
            arr.add(mover.val);
            mover = mover.next;
        }
        quickSort(arr,0,arr.size()-1);
        System.out.println(arr);
        mover = head;
        for(int ele : arr){
            mover.val = ele;
            mover=mover.next;
        }
        return head;
    }
    private void quickSort(ArrayList<Integer> arr, int low,int high){
        if(low < high){
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
        return;
    }
    private int  partition(ArrayList<Integer> arr,int low,int high){
        int pivot = arr.get(low);
        int i = low;
        int j = high;
        while(i <= j){
            while(i <= high && arr.get(i) <= pivot) i++;
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
}
public class Problem18 {
   public static ListNode addingArrToLL(int arr[]){
      ListNode head = new  ListNode(arr[0]);
      ListNode mover = head;
      for(int i=1;i<arr.length;i++){
          ListNode temp = new ListNode(arr[i]);
          mover.next = temp;
          mover=temp;
      }
      return head;  
  }

  public static void main(String[] args) {
      Solution s = new Solution();
      int[] arr = { 4,2,1,3};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("Brute Force:"+s.sortListBruteForce(head).val);
  }
}
