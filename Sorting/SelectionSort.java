import java.util.Arrays;

public class SelectionSort {
   

    public static void main(String[] args) {
        int[] a={13,46,24,52,20,9};
        int[] sortedArray=Sort(a);
        System.out.println(Arrays.toString(sortedArray));
        
    }
    public static int[] Sort(int[] nums){
        int[] sorted=nums;
        for(int i=0;i<nums.length-2;i++){
            int min=i;
            for(int j=i;j<nums.length-1;j++){
                if(sorted[j]<sorted[min]){
                    min=j;
                }
                
            }
            //Swaping without new variable
            if(min!=i){
            sorted[i]=sorted[i]+sorted[min];
            sorted[min]=sorted[i]-sorted[min];
            sorted[i]=sorted[i]-sorted[min];
            }

        }

        return sorted; 
    }
}
