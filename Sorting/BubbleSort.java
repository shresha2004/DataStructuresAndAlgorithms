import java.util.Arrays;

public class BubbleSort {
    public static int[] Sort(int[] arr){
        int n=arr.length;
        int didSwap=0;//Helps in TC for best case
        for(int i=n-1;i>=1;i--){
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    didSwap=1;
                }

            }
            if(didSwap==0){
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] a={13,46,24,52,20,9};
        int[] sorted=Sort(a);
        System.out.println(Arrays.toString(sorted));
        
    }
}
