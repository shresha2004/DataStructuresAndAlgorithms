//Problem:https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1
class MyStack {
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        StackNode newNode = new StackNode(a);
        newNode.next = top;
        top = newNode;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if(top == null) return -1;
        int removed = top.data;
        top = top.next;
        return removed;
    }
}
public class Problem5 {
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(2);
        st.push(30);
        st.push(05);
        st.push(30);
        st.push(06);
        System.out.println(st.pop()); 
    
    }
}
