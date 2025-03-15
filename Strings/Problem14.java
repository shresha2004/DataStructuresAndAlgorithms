class Solution {
    public int strStrBruteForce(String haystack, String needle) {
        int n = haystack.length();
        for(int i=0;i<=(n-needle.length());i++){
            String check = haystack.substring(i,i+needle.length());
            System.out.println(check);
            if(check.equals(needle)){
                return i;
            }
        }
        return -1;
    }
    public int strStrOptimal(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i=0;i<=n-m;i++){
            int j =0;
            while(j<m && haystack.charAt(i+j)==needle.charAt(j)) j++;
            if(j==m) return i;
        }
       return -1;
    }
}

public class Problem14 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("Brute Force:"+s.strStrBruteForce(haystack, needle));
        System.out.println("Optimal:"+s.strStrOptimal(haystack, needle));
    }
}
