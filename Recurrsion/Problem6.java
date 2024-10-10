class Solution {
    int count=0;
    public void reverseArray(int arr[]) {
        // code here
        int i,j;
       
       for( i=0,j=arr.length-1;i<j;i++,j--){
           int temp =arr[i];
           arr[i]=arr[j];
           arr[j]=temp;
           
       }
       for(i=0;i<arr.length;i++){
       System.out.print(arr[i]+" ");
       }
    }
}
public class Problem6 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={1,2,3,4};
        s.reverseArray(a);
    }
}
