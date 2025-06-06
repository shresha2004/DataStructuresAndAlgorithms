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

    public ListNode sortListBetter(ListNode head) {
        if(head == null || head.next == null) return head;
       ListNode mover1 = head;
       for(;mover1 != null;mover1=mover1.next){
        for(ListNode mover2 = mover1.next;mover2 != null;mover2=mover2.next ){
            if(mover2.val < mover1.val){
                int temp = mover2.val;
                mover2.val = mover1.val;
                mover1.val = temp;
            }
        }
       }
       return head;
    }
    //Optimal using Merge Sort
    public ListNode sortListOptimal(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode middle = findmiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;
        left = sortListOptimal(left);
        right = sortListOptimal(right);
        return merge(left,right);
    }
    private ListNode merge(ListNode list1, ListNode list2){
            ListNode dummyNode = new ListNode(-1);
            ListNode temp=dummyNode;
            while(list1 != null && list2 != null){
                if(list1.val >= list2.val){
                    temp.next = list2;
                    list2 = list2.next;
                }else{
                    temp.next = list1;
                    list1 = list1.next;
                }
                temp = temp.next;
            }
            if(list1 != null){
                temp.next = list1;
            }
            else {
                temp.next = list2;
            }
            return dummyNode.next;
    }
    private ListNode findmiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
      System.out.println("Better:"+s.sortListBetter(head).val);
      System.out.println("Optimal:"+s.sortListBetter(head).val);
  }
}
