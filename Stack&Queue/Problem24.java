//Problem:https://leetcode.com/problems/online-stock-span/description/
import java.util.*;
class Pair<Index,Value>{
    Index a;
    Value b;
    Pair(Index a,Value b){
        this.a = a;
        this.b=b;
    }
}
class StockSpannerBruteForce {
      ArrayList<Integer> arr;

    public StockSpannerBruteForce() {
        arr = new ArrayList<>();
    }
    
    public int next(int price) {
     
        arr.add(price);
        int count = 1; //Curr price shd be included
        for(int i=arr.size()-2;i>=0;i--){
            if(arr.get(i)<= price) count++;
            else break;
        }
    return count;
    }
}

class StockSpannerOptimal {
    Stack<Pair<Integer,Integer>> st;
    int index;
    public StockSpannerOptimal() {
      st = new Stack<>();
      index=-1;
    }
    
    public int next(int price) {
     index++;
     int ans =0;
     while(!st.isEmpty() && st.peek().b<= price)
         st.pop();

        ans =index - ((st.isEmpty())? -1: st.peek().a);
        st.push(new Pair<>(index,price));
     
     return ans;
      
    }
}
public class Problem24{
    public static void main(String[] args) {
        StockSpannerBruteForce spb = new StockSpannerBruteForce();
        System.out.println("Brute Force:"+spb.next(100));

        StockSpannerOptimal spo = new StockSpannerOptimal();
        System.out.println("Optimal:"+spo.next(100));
    }
}


