package mikecoleman.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Mike on 10/12/2015.
 * This will map various users names with their resting heartrate
 */
public class RestingHrHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Mike", 58);
        map.put("Megan", 54);
        map.put("Denise", 62);
        map.put("Lisa", 74);
        map.put("Sara", 65);
        map.put("Dead person", 0);

        // *****************The following are some HAPPY paths*********************


        // This gets the corresponding value from the requested key
        Integer mapValue = map.get("Mike");
        System.out.println("Mike's resting heartrate is " + mapValue);

        // If you request a value for a key that does not exist, you get null
        Integer mapValue2 = map.get("Bob");
        System.out.println(mapValue2);

        // If you try to add another key that you already have, the corresponding value overwrites the former value
        map.put("Sara", 70);
        System.out.println("Sara's new resting heartrate is " + map.get("Sara"));

        // Lets you remove a mapping rom the HashMap
        map.remove("Dead person");

        // Prints all the keys in the HashMap
        System.out.println(map.keySet());
        // Prints all the values in the HashMap
        System.out.println(map.values());
        // Prints all the mappings in the HashMap (keys to corresponding values)
        System.out.println(map.entrySet());
        // Prints out how many mappings there are in the HashMap
        System.out.println(map.size());


        // This would clear the HashMap of all keys and values
        // map.clear();

        // This checks if the HashMap is or is not empty
        if (map.isEmpty()) {
            System.out.println("The HashMap is empty");
        } else {
            System.out.println("The HashMap is not empty");
        }
        /*
        Creates a second HashMap and copies the mappings from the original map into itself
        Note that you can take this from a LinkedHashMap and put it into a normal HashMap
        */
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.putAll(map);
        System.out.println(map2.entrySet());

        // Checks if the two created HashMaps are the same
        System.out.println(map.entrySet().equals(map2));


        // *****************The following are some NASTY paths*********************

        // Inserting a negative load factor
        LinkedHashMap<String, Integer> anotherMap = new LinkedHashMap(16, (float) -.75);


    }
}
