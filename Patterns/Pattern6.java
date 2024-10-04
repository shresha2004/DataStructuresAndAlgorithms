public class Pattern6 {
    public static void main(String[] args) {
        int n=3;
        int j;
        for(int i=0;i<n;i++){
            if(i<n/2){
                for(j=0;j<(n/2-i-1);j++ ){
                    System.out.print(" ");
                }
                for(j=0;j<(2*i+1);j++){
                    System.out.print("*");
                }
                for(j=0;j<(n/2-i-1);j++){
                    System.out.print(" ");
                }
                System.out.println();
            }
            else{
                for(j=((n/2));j<i;j++ ){
                    System.out.print(" ");
                }
                for(j=0;j<(2*(n-i-1)+1);j++){
                    System.out.print("*");
                }
                for(j=((n/2));j<i;j++){
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
    
}
