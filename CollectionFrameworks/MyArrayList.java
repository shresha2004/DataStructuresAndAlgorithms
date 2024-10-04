import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList{
    public static void main(String[] args) {
        //Object Declaration
        ArrayList<Integer> list = new ArrayList<>();


        //Adding Elements
            list.add(10);//Single element
            list.addAll(Arrays.asList(20,30,40,50));//Multiple elements
            System.out.println("Adding Elements:"+list);


        //Getting Element
            int ele=list.get(2);
            System.out.println("Getting Element:"+ele);

        //Adding element in between
            list.add(2,25);
            System.out.println("Added 25 in between:"+list);

        
        //Editing the element 
            list.set(3,35);
            System.out.println("Edited 30 as 35:"+list);

        //Deleting the element
            list.remove(3);
            System.out.println("Removed element 35:"+list);
        
        //Determing size
            int s=list.size();
            System.out.println("Size of the array list is:"+s);

        //looping
        System.out.println("Looping to each element:");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }


        

    }
}