public class Pattern12 {
    public static void main(String[] args) {
        int n=10;
        for(int i=0;i<n;i++){
            if(i<n/2){
            for(int j=0;j<(n/2-i);j++){
                System.out.print("*");
            }
            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<(n/2-i);j++){
                System.out.print("*");
            }
            
        }else{
            for(int j=0;j<i-4;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*(n-i-1);j++){
                System.out.print(" ");
            }
            for(int j=0;j<i-4;j++){
                System.out.print("*");
            }

        }

            System.out.println();
        }
       
    }
    
}
