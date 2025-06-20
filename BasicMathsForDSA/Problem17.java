//Problem:https://www.geeksforgeeks.org/problems/all-divisors-of-a-number/1

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> print_divisorsBruteForce(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                ans.add(i);
        }
        // System.out.print(n);
        return ans;
    }
     public ArrayList<Integer> print_divisorsBetter(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0)
                ans.add(i);
        }
        ans.add(n);
        return ans;
    }
     public ArrayList<Integer> print_divisorsOptimal(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0)
                ans.add(i);
                if(n%(n/i)==0) ans.add(n/i);
        }
      
        return ans;
    }
}

public class Problem17 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num =100 ;
        System.out.println("Brute Force:"+s.print_divisorsBruteForce(num));
        System.out.println("Better:"+s.print_divisorsBetter(num));
       System.out.println("Optimal:"+s.print_divisorsOptimal(num));
    }
}
