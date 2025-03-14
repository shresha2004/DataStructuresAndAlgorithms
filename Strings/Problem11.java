//Problem:https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-number-of-substrings
import java.util.HashSet;
import java.util.HashMap;
class Solution {
    int countSubstrBruteForce(String s, int k) {
        // your code here
        int count =0;
        int len = s.length();
        for(int i=0;i<len;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=i;j<len;j++){
                set.add(s.charAt(j));
                if(set.size()==k) count++;
              else  if(set.size() > k) break;
            }
        }
        return count;
    }

    int countSubstrOptimal(String s, int k) {
        // your code here
       return countAtMost(s,k)- countAtMost(s,k-1);
    }
    
    private int countAtMost(String s,int k){
        int n = s.length();
        int left = 0;int right=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        
        while(right < n){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }
            
            count += (right-left)+1;
            right++;
        }
        return count;
    }
}



public class Problem11 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "aba";
        int k = 2;
        System.out.println("Brute Force:"+s.countSubstrBruteForce(ss, k));
        System.out.println("Optimal:"+s.countSubstrOptimal(ss, k));
    }
}
