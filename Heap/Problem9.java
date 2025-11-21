//Problem:https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
import java.util.*;
class Node{
    int value;
    int i;
    int j;
    Node(int value,int i,int j){
        this.value =value;
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.value-b.value);
        int m = mat.length;
        for(int i=0;i<m;i++){
            pq.offer(new Node(mat[i][0],i,0));
        }
        
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            ans.add(temp.value);
            int i=temp.i;
            int j=temp.j+1;
            if(i< m && j<mat[i].length){
                pq.offer(new Node(mat[i][j],i,j));
            }
        }
        return ans;
    }
}
public class Problem9 {
public static void main(String[] args) {
    int  mat[][] = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
    Solution s = new Solution();
    System.out.println("Solution:"+s.mergeArrays(mat));
}
}
