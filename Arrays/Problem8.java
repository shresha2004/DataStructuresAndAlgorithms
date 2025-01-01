//Problem:https://leetcode.com/problems/missing-number/description/
class Solution {
    public int missingNumberBruteForce(int[] nums) {
        int n=nums.length;
        int missingNo=nums.length,i,j;
        boolean present;
        for(i=0;i<n;i++){
            present=false;
            for(j=0;j<n;j++){
                if(nums[j]==i){
                    present=true;
                   
                    break;
                } 
            }
          
            if(present==false){
                missingNo=i;
                break;
            }
        }
        return missingNo;
        
    }
    public int missingNumberOptimal(int[] nums) {
        int n=nums.length;
       
        int sum1=((n)*(n+1))/2;
        int sum2=0;
        for(int i=0;i<n;i++){
            sum2=sum2+nums[i];
        }
        int total=sum1-sum2;
        
        return total;
        
    }
}
public class Problem8 {
    public static void main(String[] args) {
        Solution s =new Solution();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(s.missingNumberBruteForce(nums));
        System.out.println(s.missingNumberOptimal(nums));
    }
}
