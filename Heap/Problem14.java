//Problem:https://leetcode.com/problems/task-scheduler/description/
import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
       int[] freq = new int [26];
       for(char t : tasks)
            freq[t-'A']++;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int f : freq)
            if(f>0)
                pq.offer(f);
        
        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> temp = new ArrayList<>();
            while(cycle > 0 && !pq.isEmpty()){
                int cur = pq.poll();
                if(cur-1 > 0){                  
                    temp.add(cur-1);
                }
                cycle--;
                time++;
            }
           
            for(int ele : temp)
                pq.offer(ele);

            if(pq.isEmpty()) break;
             time += cycle;
        }
        return time;
    }
}
public class Problem14 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        Solution s = new Solution();
        System.out.println("Solution:"+s.leastInterval(tasks, n));
    }
}
