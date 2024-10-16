//Problem:https://leetcode.com/problems/roman-to-integer/?envType=problem-list-v2&envId=hash-table&favoriteSlug=&difficulty=EASY
import java.util.HashMap;
class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hash=new HashMap<>();
        int total=0;
        int currentValue;
        int prevValue=0;
        hash.put('I',1);
        hash.put('V',5);
        hash.put('X',10);
        hash.put('L',50);
        hash.put('C',100);
        hash.put('D',500);
        hash.put('M',1000);

        for(int i=s.length()-1;i>=0;i--){
            currentValue=hash.get(s.charAt(i));
            if(currentValue<prevValue){
                total-=currentValue;
            }else total+=currentValue;

            prevValue=currentValue;
        }



return total;

    }
}
public class Problem7 {
    public static void main(String[] args) {
        Solution s=new Solution();
       System.out.println(s.romanToInt("IV")); ;
    }
}
