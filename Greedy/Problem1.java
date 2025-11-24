//Problem:https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

import java.util.Arrays;
import java.util.Comparator;

class Box{
    int wt;
    int val;
    Box(int wt,int val){
        this.wt = wt;
        this.val = val;
    }
}

class itemsComp implements Comparator<Box>{
        public int compare(Box a,Box b){
            double rate1 = (double) a.val/(double) a.wt;
            double rate2 = (double) b.val/ (double) b.wt;
            
            if(rate1 < rate2) return 1;
            else if(rate2 < rate1) return -1;
            else  return 0;
        }
}
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = wt.length;
        Box[] box = new Box[n];
        for(int i=0;i<n;i++){
            box[i]= new Box(wt[i],val[i]);
        }
        
        Arrays.sort(box,new itemsComp());
        double maxVal = 0.0;
        double curCap = 0.0;
        for(int i=0;i<n;i++){
            if((curCap+box[i].wt) <= capacity){
                curCap += box[i].wt;
                maxVal += box[i].val;
            }
            else{
              double remain = capacity - curCap;
              maxVal += (remain * box[i].val)/ box[i].wt;
              break;
            }
        }
        return maxVal;
        
    }
}


class Problem1 {
public static void main(String[] args) {
   int val[] = {60, 100, 120}, wt[] = {10, 20, 30}, capacity = 50;
   Solution s = new Solution();
   System.out.println("Fractional Knapsack:"+s.fractionalKnapsack(val, wt, capacity));
}
    
}