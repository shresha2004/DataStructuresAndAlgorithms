import java.util.List;
import java.util.ArrayList;
class Solution{
    //When question is asked to fill the ele in perticular row and col
    public int givenRowAndCol(int row,int col){
        int ele=nCr(row-1,col-1);
        return ele;
    }
    public int nCr(int n,int r){
        int res=1;
        for(int i=0;i<r;i++){
            res=res * (n-i);
            res=res/(i+1);

        }
        return res;
    }
    public void printRowElements(int row){
        int ans=1;
        System.out.print(ans);
        for(int i=1;i<row;i++){
            ans=ans*(row-i);
            ans=ans/i;
            System.out.print(" "+ans);
        }
    }

//Problem:https://leetcode.com/problems/pascals-triangle/description/

    public List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> finalArray= new ArrayList<>();
        for(int row=1;row<=numRows;row++){
          ArrayList<Integer> arr=new ArrayList<>();
          int ans=1;
            arr.add(ans);
            for(int j=1;j<row;j++){
                ans=ans*(row-j);
                ans=ans/j;
                arr.add(ans);
            }
           finalArray.add(arr);
        }
        return finalArray;
        
    }
}
public class Problem31 {
    public static void main(String[] args) {
        Solution s=new Solution();
       
    System.out.println("When Row and Column is given:"+s.givenRowAndCol(5,3));
    System.out.println("Element of the given row:");
    s.printRowElements(6);
    System.out.println();
    System.out.println("Generate a pascal's triangle:"+s.generatePascalsTriangle(6));
   
 
    }
}
