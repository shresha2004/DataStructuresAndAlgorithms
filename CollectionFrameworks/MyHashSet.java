import java.util.HashSet;
public class MyHashSet {
    public static void main(String[] args) {
        //Creating instance
            HashSet<Integer> set=new HashSet<>();

        //Adding elements
            set.add(10);
            set.add(20);
            set.add(30);
            set.add(40);
            set.add(50);
            System.out.println(set);

        //Remove
        System.out.println("Element 50 is removed:"+set.remove(50));

        //Checking for empty set
        System.out.println("Set is empty:"+set.isEmpty());

        //Checking for perticular element
        System.out.println("Element 60 is present:"+set.contains(60));
    }
    
}
