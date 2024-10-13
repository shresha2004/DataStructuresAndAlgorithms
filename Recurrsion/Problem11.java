//Problem: Strivers Recursion lecture 7
import java.util.ArrayList;
class Solution{
   public ArrayList<ArrayList<Integer>> subs= new ArrayList<>();
   
    int i=0;
    int sum=0;

    boolean f(int index,ArrayList<Integer> arr,int[] GivenArray){
        if(index==GivenArray.length){
            subs.add(arr);
            if(sum==4){
                System.out.println(arr);
                return true;
            }else{return false;}
            
            
        }
        arr.add(GivenArray[index]);
    
        sum+=GivenArray[index];
     if(f(index+1,new ArrayList<>(arr),GivenArray)==true){
        return true;
     };
        
        arr.remove((arr.size())-1);
        sum-=GivenArray[index];

       if( f(index+1,new ArrayList<>(arr),GivenArray)==true){
        return true;
       };
       return false;
    }
    

}
public class Problem11 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr={2,2,3,1};
       System.out.println(s.f(0, new ArrayList<>(), arr)); 
       //System.out.println(s.subs);
        
    }
    
}

