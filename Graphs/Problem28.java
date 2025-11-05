//Problem:https://www.geeksforgeeks.org/problems/disjoint-set-union-find/1
class Solution{
     int find(int par[], int x) {
        // add code here.
        //Ultimate Parent
        if(par[x]==x) return x;
        
        //Finding ultimate parent and assigining ultimate parent to all child node
        //Path compression
        par[x]=find(par,par[x]);
        
        return par[x];
    }

    void unionSet(int par[], int x, int z) {
      int ultiU= find(par,x);
       int ultiV=find(par,z);
       //Assigning parent according to rank
       par[ultiU]=ultiV;
        return;
    }
}
public class Problem28 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] par= {0,1,2,3};
        System.out.println("Disjoint set:"+ s.find(par, 3));
    }
}
