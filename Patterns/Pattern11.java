public class Pattern11 {
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            char ch='A';
            int brekpoint=i;
            for(int j=0;j<=2*i;j++){
                System.out.print(ch);
                if(j<brekpoint) ch++;
                else ch--;
                
            }
            for(int j=0;j<n-i-1;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
}
