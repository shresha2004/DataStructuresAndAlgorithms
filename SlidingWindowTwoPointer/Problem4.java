//Problem:https://leetcode.com/problems/fruit-into-baskets/description/
import java.util.*;
class Solution{
 public int totalFruitBruteForce(int[] fruits) {
     HashMap<Integer,Integer> map = new HashMap<>()   ;
     int left = 0;
     int right = 0;
     int n = fruits.length;
     int maxLen = 0;
     while(right < n){
        map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
        
           if(map.size()>2){
            map.put(fruits[left],map.get(fruits[left])-1);
            if(map.get(fruits[left])==0) map.remove(fruits[left]);
            left++;
           }
        
         if(map.size() <= 2) maxLen = Math.max(maxLen,(right-left)+1);

        right++;

     }
     return maxLen;
    }
     public int totalFruitOptimal1(int[] fruits) {
    int maxLen = 0;
    int n = fruits.length;
    for(int i=0;i<n;i++){
        HashSet<Integer> set = new HashSet<>();
        int len =0;
        for(int j=i;j<n;j++){
                set.add(fruits[j]);
                if(set.size()>2) break;
                maxLen =Math.max(maxLen,(j-i)+1);
        }
    }
     return maxLen;
    }
    public int totalFruitOptimal2(int[] fruits) {
     HashMap<Integer,Integer> map = new HashMap<>()   ;
     int left = 0;
     int right = 0;
     int n = fruits.length;
     int maxLen = 0;
     while(right < n){
        map.put(fruits[right],right);
        if(map.size()>2){
            int minIndex = Integer.MAX_VALUE;
            int minValue = Integer.MAX_VALUE;
           for(Map.Entry<Integer,Integer> ele : map.entrySet()){
                if(ele.getValue() < minIndex){
                    minIndex = ele.getValue();
                    minValue = ele.getKey();
                }
           }
           left = minIndex+1;
           map.remove(minValue);
        }
          maxLen = Math.max(maxLen,(right-left)+1);

        right++;

     }
     return maxLen;
    }
    public int totalFruitOptimal3(int[] fruits) {
     HashMap<Integer,Integer> map = new HashMap<>()   ;
     int left = 0;
     int right = 0;
     int n = fruits.length;
     int maxLen = 0;
     while(right < n){
        map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
        
           while(map.size()>2){
            map.put(fruits[left],map.get(fruits[left])-1);
            if(map.get(fruits[left])==0) map.remove(fruits[left]);
            left++;
           }
        
          maxLen = Math.max(maxLen,(right-left)+1);

        right++;

     }
     return maxLen;
    }
     public int totalFruitOptimal4(int[] fruits) {
     HashMap<Integer,Integer> map = new HashMap<>()   ;
     int left = 0;
     int right = 0;
     int n = fruits.length;
     int maxLen = 0;
     while(right < n){
        map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
        
           if(map.size()>2){
            map.put(fruits[left],map.get(fruits[left])-1);
            if(map.get(fruits[left])==0) map.remove(fruits[left]);
            left++;
           }
        
         if(map.size()<= 2) maxLen = Math.max(maxLen,(right-left)+1);

        right++;

     }
     return maxLen;
    }
}
public class Problem4 {
    public static void main(String[] args) {
        Solution s = new Solution();
       int[] fruits = {1,2,1};
        System.out.println("Brute Force:"+s.totalFruitBruteForce(fruits));
       System.out.println("Optimal 1:"+s.totalFruitOptimal1(fruits));
       System.out.println("Optimal 2:"+s.totalFruitOptimal2(fruits));
       System.out.println("Optimal 3:"+s.totalFruitOptimal3(fruits));
       System.out.println("Optima 4:"+s.totalFruitOptimal4(fruits));
    }
}
