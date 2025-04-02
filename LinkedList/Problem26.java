//Problem:https://leetcode.com/problems/reverse-nodes-in-k-group/description/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next=null;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode mover = head;
        ListNode previousNode = null;
        while(mover != null){
            ListNode kthNode = findKthNode(mover,k);
            if(kthNode == null){ 
              if(previousNode != null)  previousNode.next = mover;
                break;
                }
          ListNode  nextNode = kthNode.next;
            kthNode.next = null;
           ListNode newHead = reverseNodes(mover);

            if(mover == head){
                head = newHead;

            }
            else{
                previousNode.next =newHead;
            }
            previousNode = mover;
            mover = nextNode;

        }
        return head;
    }
    private ListNode findKthNode(ListNode mover, int k){
       
        while(mover != null && k>1){
           
            mover = mover.next;
            k--;
        }
        return mover;
    }
    private ListNode reverseNodes(ListNode mover){
        ListNode previous = null;
        while(mover != null){
            ListNode temp = mover.next;
            mover.next = previous;
            previous = mover;
            mover = temp;
           
        }
        return previous;
    }
}
public class Problem26 {
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
      int[] arr = { 1,2,3,4,5};
     ListNode head= addingArrToLL(arr);
     
      System.out.println("Answer:"+s.reverseKGroup(head, 2).val);
  }
}
