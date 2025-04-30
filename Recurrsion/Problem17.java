//Problem:

import java.util.Stack;

class Solution{
    static Stack<Integer> reverseBruteForce(Stack<Integer> s) {
        // add your code here
       Stack<Integer> ans1 = new Stack<>();
       Stack<Integer> ans2 = new Stack<>();
       while(!s.isEmpty()) ans1.push(s.pop());
       while(!ans1.isEmpty()) ans2.push(ans1.pop());
       while(!ans2.isEmpty()) s.push(ans2.pop());
       return s;
    }
    static Stack<Integer> reverseOptimal(Stack<Integer> s) {
        // add your code here
        if(!s.isEmpty()){
            int temp = s.pop();
            reverseOptimal(s);
            addBottom(s,temp);
            
        }
        return s;
    }
    static void addBottom(Stack<Integer> s,int x){
        if(s.isEmpty()){
            s.push(x);
        }else{
            int temp = s.pop();
            addBottom(s,x);
            s.push(temp);
        }
    }
}
public class Problem17 {
    public static void main(String[] args) {
         int[] arr ={ 11 ,2, 32 ,3 ,41};
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int ele: arr){
            stack1.push(ele);
        }
        for(int ele: arr){
            stack2.push(ele);
        }
        Solution s = new Solution();
        System.out.println("Brute Force:"+s.reverseBruteForce(stack1));
        System.out.println("Optimal:"+s.reverseOptimal(stack2));
    }
}
