public class Pattern5 {
    public static void main(String[] args) {
        int j;
        for(int i=0;i<5;i++){
            for(j=0;j<i;j++ ){
                System.out.print(" ");
            }
            for(j=0;j<(2*(5-i-1)+1);j++){
                System.out.print("*");
            }
            for(j=0;j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
}
