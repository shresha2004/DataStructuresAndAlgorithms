//Problem:https://leetcode.com/problems/longest-repeating-character-replacement/description/
class Solution {
     public int characterReplacementBruteForce(String s, int k) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int[] hash= new int[256];
            int maxFreq = 0;
            for(int j=i;j<n;j++){
                hash[s.charAt(j)]+=1;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j)]);
                int replace = (j-i+1)- maxFreq;
                if(replace <= k) maxLen = Math.max(j-i+1,maxLen);
                else break;
              
            }
        }
    return maxLen;
    }
    public int characterReplacementOptimal(String s, int k) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int[] hash = new int[26];
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        while(right < n){
            hash[s.charAt(right)-'A']+=1;
            maxFreq =Math.max(maxFreq,hash[s.charAt(right)-'A']);
            while((right - left +1)-maxFreq > k ){
                hash[s.charAt(left)-'A']-=1;
                left++;
            }
            maxLen = Math.max((right-left+1),maxLen);
            right++;
        }    
    return maxLen;
    }
}
public class Problem3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss= "ABAB";
        System.out.println("Brute Force:"+s.characterReplacementBruteForce(ss, 2));
       System.out.println("Optimal:"+s.characterReplacementOptimal(ss, 8));
    }
}


