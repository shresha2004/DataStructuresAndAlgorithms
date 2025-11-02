//Problem:https://www.geeksforgeeks.org/problems/alien-dictionary/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String findOrder(String[] words) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = words.length;
        for(int i=0;i<26;i++)
            adj.add(new ArrayList<>());
            
        for(int i=0;i<n-1;i++){
            String str1 = words[i];
            String str2 = words[i+1];
            boolean found =false;
            int len = Math.min(str1.length(),str2.length());
            for(int j=0;j<len;j++){
                if(str1.charAt(j) != str2.charAt(j)){
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    found=true;
                    break;
                }
            }
            if(str1.length()>str2.length() && found == false)
                return "";
        }
        
        int[] inDegree = new int[26];
        boolean[] isPresent = new boolean[26];
        for(int i=0;i<n;i++){
           for(int j=0;j<words[i].length();j++){
               isPresent[words[i].charAt(j)-'a']=true;
           }
        }
        for(int i=0;i<26;i++){
            for(int neigh : adj.get(i)){
                inDegree[neigh]++;
                
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(isPresent[i] && inDegree[i]==0 ){
               q.offer(i);

            } 
        }
            
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append((char) ('a'+node));
            for (int ele : adj.get(node)){
                inDegree[ele]--;
                if(inDegree[ele]==0)
                    q.offer(ele);
                    
            }
        }
        
       
    
    for(int i=0;i<26;i++){
        if(isPresent[i] && sb.indexOf(""+(char)('a'+i))==-1)
        return "";
    }
     return sb.toString();
}
}
public class Problem24 {
    public static void main(String[] args) {
      String  words[] = {"baa", "abcd", "abca", "cab", "cad"};
      Solution sol = new Solution();
      System.out.println("Solution:"+sol.findOrder(words));
    }
}
