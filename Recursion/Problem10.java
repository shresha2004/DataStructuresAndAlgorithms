//Problem: Strivers Recursion lecture 7
import java.util.ArrayList;
class Solution{
   public ArrayList<ArrayList<Integer>> subs= new ArrayList<>();
   
    int i=0;
    int sum=0;

    void f(int index,ArrayList<Integer> arr,int[] GivenArray){
        if(index>=GivenArray.length){
            
            if(sum==4){
                System.out.println(arr);
            }
            subs.add(arr);
            return;
        }
        arr.add(GivenArray[index]);
    
        sum+=GivenArray[index];
        f(index+1,new ArrayList<>(arr),GivenArray);
        
        arr.remove((arr.size())-1);
        sum-=GivenArray[index];
        f(index+1,new ArrayList<>(arr),GivenArray);
    }
    

}
public class Problem10 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr={3,1,2};
        s.f(0, new ArrayList<>(), arr);
       //System.out.println(s.subs);
        
    }
    
}