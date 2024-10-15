import java.util.LinkedHashMap;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        LinkedHashMap<String,Integer> map=new LinkedHashMap<>();
        for(int i=1;i<6;i++){
            String s=sc.nextLine();
            map.put(s, i);
        }
        System.out.println(map);

    }
}
