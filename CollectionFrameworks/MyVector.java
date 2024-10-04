import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;


public class MyVector {
    public static void main(String[] args) {
        //Object declaration
        Vector<Integer> vc=new Vector<>();

        //Adding elements
            vc.add(60);
            vc.add(1,70);
           // vc.adAll(Arrays.asList(80,90,100)) is not possible
           vc.add(80);
           vc.add(90);
           vc.add(100);

            System.out.println("Elements are added to vector:"+vc);
        //Accessing elements
            int ele=vc.get(2);
            System.out.println("Accessing ele:"+ele);
        
        //Removing elements
            vc.remove(2);
            System.out.println("Element 80 removed:"+vc);

        //Iteration
        System.out.println("Iterating all elements:");
            for(Integer num : vc){
                System.out.print(num+" ");
            }
            System.out.println();

        //Size
            System.out.println("Size of vector:"+ vc.size());
        
        //Reverse
            Collections.reverse(vc);
            System.out.print(vc);
    }
}
