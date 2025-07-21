//Problem:https://leetcode.com/problems/asteroid-collision/description/
import java.util.*;
class Solution {
    public int[] asteroidCollisionOptimal(int[] asteroids) {
        ArrayList<Integer> stack = new ArrayList<>();
        int n = asteroids.length;
        for(int i=0;i<n;i++){
            int ele = asteroids[i];
           if(ele>0) stack.add(ele);
           else{ 
            while(!stack.isEmpty()&& stack.get(stack.size()-1)>0 && stack.get(stack.size()-1)<Math.abs(ele)) 
            stack.remove(stack.size()-1);
           

            if(!stack.isEmpty() && stack.get(stack.size()-1)==Math.abs(ele))
             stack.remove(stack.size()-1);
           else if(stack.isEmpty() || stack.get(stack.size()-1)<0) stack.add(ele);
           }
        }
    
    int[] ans = new int[stack.size()];
    for(int i=0;i<stack.size();i++){
        ans[i]=stack.get(i);
    }
    return ans;
}
}
public class Problem18 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] asteroids = {5,10,-5};
        System.out.println("Solution:"+s.asteroidCollisionOptimal(asteroids));
    }
}
