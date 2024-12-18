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
    ArrayList<Integer> findTwoElementBetter(int arr[]) {
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
       
        int n=arr.length;
        int[] freq = new int[n+1];
        
        for(int i=0;i<n;i++){
           
           freq[arr[i]]=freq[arr[i]]+1;
           
        }
        int missing=-1;
        int repeating=-1;
        
        for(int i=1;i<=n;i++){
         
           if(freq[i]==0) missing=i;
           if(freq[i]==2) repeating=i;
           
        }
        ans.add(repeating);
        ans.add(missing);
        
        
        return ans;
    }
    ArrayList<Integer> findTwoElementOptimal1(int arr[]) {
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
       
        int n=arr.length;
        long S= (long) n*(n+1)/2;
        long S2 =(long) n*(n+1) * (2*n+1)/6;
        
        
        long SN=0;
        long S2N=0;
        
        for(int i=0;i<n;i++){
            SN+=arr[i];
            S2N+= (long)  arr[i] *  arr[i];
            
        }
        long val1= S-SN;
        long val2=S2-S2N;
        val2 = val2/val1;
        long x= (val2+val1)/2;
        long y=x-val1;
        ans.add((int) y);
        ans.add((int)x);
       
        
        
        return ans;
    }
}
public class Problem40 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] arr = {2, 2};
       System.out.println("Brute Force Approach:"+s.findTwoElementBruteForce(arr)); 
       System.out.println("Better Approach:"+s.findTwoElementBetter(arr)); 
       System.out.println("Optimal Approach 1:"+s.findTwoElementOptimal1(arr)); 

    }
}
