//Problem:https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
import java.util.*;
class Solution{
     public int numberOfSubstringsBruteForce(String s) {
      int count = 0;
      int n = s.length();
        for(int i=0;i<s.length();i++){
                  int[] isPresent = new int[3];
            for(int j=i;j<n;j++){
               
                    isPresent[s.charAt(j)-'a']+=1;
               
                if(isPresent[0] != 0 && isPresent[1] != 0 && isPresent[2] != 0)
                    count+=1;
            }
        }
        return count;
    }
 public int numberOfSubstringsOptimal(String s) {
      int count = 0;
      int n = s.length();
                  int[] isPresent = new int[3];
       Arrays.fill(isPresent,-1);
        for(int i=0;i<s.length();i++){    
                    isPresent[s.charAt(i)-'a']=i;
            if(isPresent[0] != -1 && isPresent[1] != -1 && isPresent[2] != -1)
               count += Math.min(isPresent[0],Math.min(isPresent[1],isPresent[2]))+1;
            }
        return count;

        }
}
public class Problem7 {
    public static void main(String[] args) {
        Solution s = new Solution();
       String  sd = "abcabc";
        System.out.println("Brute Force:"+s.numberOfSubstringsBruteForce(sd));
      System.out.println("Optimal:"+s.numberOfSubstringsOptimal(sd));
    }
}
