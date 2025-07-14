//Problem: Strivers Recursion lecture 7
import java.util.ArrayList;
class Solution{
   public ArrayList<ArrayList<Integer>> subs= new ArrayList<>();
   
    
    //int sum=0;
 

    int f(int index,int sum,int[] GivenArray){
        if(index>=GivenArray.length){
           
            if(sum==4){
                return 1;
            }else{return 0;}
 
        }
       
    
        sum+=GivenArray[index];
        int l= f(index+1,sum,GivenArray);
   
       sum-=GivenArray[index];

       int r= f(index+1,sum,GivenArray);
       
       return l+r;
    }
    

}
public class Problem12 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr={3,1,2};
       System.out.println(s.f(0,0, arr)); 
       //System.out.println(s.subs);
        
    }
    
}

