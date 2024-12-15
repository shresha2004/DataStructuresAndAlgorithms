import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElementBruteForce(int arr[]) {
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
        int repeating =-1;
        int missing=-1;
        int n=arr.length;
        
        for(int i=1;i<=n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[j]==i){
                    count++;
                }
                
            }
            if(count==2) repeating=i;
             else if(count==0) missing = i;
             
            if(repeating != -1 && missing != -1) break;
        }
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }
}
public class Problem40 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] arr = {2, 2};
       System.out.println(s.findTwoElementBruteForce(arr)); 

    }
}
