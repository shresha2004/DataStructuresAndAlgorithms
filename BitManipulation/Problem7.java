//Problem:https://leetcode.com/problems/single-number-iii/description/?envType=problem-list-v2&envId=bit-manipulation
import java.util.HashMap;
import java.util.Arrays;
class Solution{
 public int[] singleNumberBruteForce(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int[] ans = new int[2];
        int i=0;
        for(int ele : nums){
            if(map.get(ele)==1){
                ans[i]=ele;
                i++;
            }
        }
        return ans;
    }
}
public class Problem7 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num ={1,2,1,3,2,5} ;
        System.out.println("Brute Force:"+Arrays.toString(s.singleNumberBruteForce(num)));
    }
}

