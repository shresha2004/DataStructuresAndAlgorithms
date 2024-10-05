import java.util.HashMap;
public class MyHashMap {
    public static void main(String[] args) {

        //Creating instance
            HashMap<String ,Integer> map=new HashMap<>();
        
        //Adding elements
            map.put("Jhon",84645);
            map.put("Reo",64465);
            map.put("Ram",654665);
            map.put("Sony",57745);
            map.put("Sam",84589859);
            System.out.println(map);

        //Accessing perticular element
            int id =map.get("Jhon");
            System.out.println("Id of jhon:"+id);

        //Removing element from map
            int removed=map.remove("Sam");
            System.out.println("Sam's id is removed:"+removed);

        //Checking for the key
            boolean key1=map.containsKey("Jhon");
            System.out.println("Jhon key is present:"+key1);

        //Checking for value
            boolean value1=map.containsValue(654665);
            System.out.println("Value 654665 is present:"+value1);

        //Set view of the keys
            System.out.println("Set view of the keys:"+map.keySet());

        //Set view of the values
            System.out.println("Set view of the values:"+map.values());

        // Set view of the mappings contained in the map.
            System.out.println("Set view of the mappings contained in the map:"+map.entrySet());



    }
    
}
