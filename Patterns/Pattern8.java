public class Pattern8 {
    public static void main(String[] args) {
        int start;
        int n=5;
        for(int i=0;i<n;i++){
            if(i%2==0){
                start=0;
            }
            else{
                start=1;

            }
            for(int j=0;j<=i;j++){
                System.out.print(start);
                start=1-start;
                
            }
            System.out.println();
        }
    }
    
}
