//Problem:https://leetcode.com/problems/course-schedule/description/
import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++)
                adj.add(new ArrayList<>());
        
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
                for(int ele : adj.get(i))
                    inDegree[ele]++;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0)
                    q.offer(i);

    int topo = 0;
    while(!q.isEmpty()){
        int node = q.poll();
        topo++;
        for(int neigh : adj.get(node)){
            inDegree[neigh]--;
            if(inDegree[neigh]==0)
                q.offer(neigh);
        }
    }
    return (topo==numCourses);

    }
}
public class Problem19 {
    public static void main(String[] args) {
       int numCourses = 2;
       int[][] prerequisites = {{1,0},{0,1}};
       Solution sol = new Solution();
       System.out.println("Topo sort solution:"+sol.canFinish(numCourses, prerequisites));
    }
}
