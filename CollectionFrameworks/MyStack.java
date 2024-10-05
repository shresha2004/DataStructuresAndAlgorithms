import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> newStack= new Stack<>();

        //Adding element
            newStack.push(10);
            newStack.push(20);
            newStack.push(30);
            newStack.push(40);
            newStack.push(50);
            System.out.println(newStack);

            
        //Checking top of the stack
            int a= newStack.peek();
           System.out.println("Top element is:"+a);

        //Removing the top element
            int removed=newStack.pop();
            System.out.println("Element removed is:"+removed);

        //Checking for empty stack
            System.out.println("Stack is empty:"+newStack.isEmpty());

    }
    
}
