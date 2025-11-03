//Problem:https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
import java.util.*;
class Pair{
    int node;
    int step;
    Pair(int node,int step){
        this.step = step;
        this.node = node;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        // Your code here
        final int MOD = 100000;
        int[] distance = new int[100000];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start,0));
        
        while(!q.isEmpty()){
            Pair curNode = q.poll();
            
            for(int nextNode : arr){
                int node = (curNode.node * nextNode )%MOD;
                
                if(curNode.step+1 < distance[node]){
                    if(node == end) return curNode.step+1;
                    distance[node]=curNode.step+1;
                    q.offer(new Pair(node,curNode.step+1));
                }
            }
        }
        return -1;
    }
}
public class Problem26 {
    public static void main(String[] args) {
      int  arr[] = {2, 5, 7};
int start = 3, end = 30;
Solution s = new Solution();
System.out.println("Solution:"+s.minimumMultiplications(arr, start, end));
    }
}
