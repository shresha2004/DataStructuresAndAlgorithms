//Problem:https://leetcode.com/problems/course-schedule-ii/description/
import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int n = prerequisites.length;
       //Step 1 : Configuration for easy access
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //Step 2: Finding indegree
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int neigh : adj.get(i)){
                inDegree[neigh]++;
            }
        }

        //Step 3: Topo sort
        int[] topo = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
                if(inDegree[i]==0)
                    q.offer(i);
        int a=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topo[a++] =node;
            for(int neigh : adj.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh]==0)
                    q.offer(neigh);
            }
        }
        return (a==numCourses)?topo:new int[] {};
    }
}
public class Problem20 {
    public static void main(String[] args) {
        Solution sol = new Solution();
       int numCourses = 4;
       int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
       System.out.println("Topo Application Solution:"+Arrays.toString(sol.findOrder(numCourses, prerequisites)));
    }
}
