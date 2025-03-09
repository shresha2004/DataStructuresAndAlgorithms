//Problem:https://leetcode.com/problems/reverse-words-in-a-string/description/
import java.util.Arrays;
class Solution {
    public String reverseWordsBruteForce(String s) {
       String[] words = s.trim().split("\\s+");
       StringBuilder result = new StringBuilder();
        System.out.println(Arrays.toString(words));
       for(int i=words.length-1;i>=0;i--){
        result.append(words[i]).append(" ");
       }
       return result.toString().trim();
    }

        public String reverseWordsOptimal(String s) {
           char[] str = s.toCharArray();
           int n = str.length;
           reverseChar(str,0,n-1);
           reverseArray(str,n);
         return  cleanSpace(str,n);
    
        }
        private void reverseArray(char[] str,int n){
            int i = 0;
            int j = 0;
            while(i<n){
                while(i<n && str[i]==' ') i++;
                j=i;
                while(j<n && str[j] !=' ') j++;
                if (i < j) reverseChar(str,i,j-1);
                i=j;
            }
        }
    
        private void reverseChar(char[] str, int left,int right ){
            while(left < right){
                char temp = str[left];
                str[left++]=str[right];
                str[right--]=temp;
            }
        }
    
        private String cleanSpace(char[] str,int n){
            int i=0,j=0;
            while(j<n){
                while(j<n && str[j] ==' ')j++;
                while(j<n && str[j] !=' ') str[i++]=str[j++];
                while(j<n && str[j]==' ')j++;
                if(j<n) str[i++]=' ';
            }
            if (i > 0 && str[i - 1] == ' ') i--; 
            return new String(str,0,i);
        }
    }



public class Problem2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "the sky is blue";
        System.out.println("Brute Force:"+s.reverseWordsBruteForce(str));
        System.out.println("Optimal:"+s.reverseWordsOptimal(str));
        
    }
}
