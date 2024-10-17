import java.util.Arrays;

public class InsertionSort {
    public static int[] Sort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp=arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
                j--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr={14,9,15,12,6,8,13};
       int[] sorted= Sort(arr);
       System.out.println(Arrays.toString(sorted));
    }
}
