package joseph.peterson.collections;

import java.util.HashMap;

/**
 * Created by Joseph on 10/20/2015.
 */
/////////////////////////////////////////////HAPPY PATHS///////////////////////////////////////////
//HashMaps have key/ values.
public class MyMap {
    public static void main(String[] args) {
        MyMap run = new MyMap();
        run.Map();
    }

    public void Map() {
        HashMap<String, Integer> aNewMap = new HashMap<>();

        //adding key/value to the hashmap.

        aNewMap.put("bilbo Baggins", 1);
        aNewMap.put("Bruce Wayne", 2);
        aNewMap.put("Clark Kent", 3);
        aNewMap.put("joseph peterson", 4);
        System.out.println(aNewMap);

        //getting a value from a specified key.
        int number = aNewMap.get("Bruce Wayne");
        System.out.println("Bruce Wayne's id is :" + number);
        //using remove, isEmpty, and clear functions
        aNewMap.remove("Clark Kent");
        System.out.println("In here is :" + aNewMap);
        if (!aNewMap.isEmpty()){
            aNewMap.clear();
            System.out.println("We deleted what was in here.");
        }else {

            System.out.println("nothing here to begin with");
        }
        System.out.println("now we have " + aNewMap.clone());

        ///////////////////////////////////////////////////NASTY PATHS//////////////////////////////////////////////////////

        //try different value same key, key is null, key and value null

        try {
            int mike = aNewMap.get("miklesawskie");
            System.out.println(mike);
        } catch (Exception e) {
            System.out.println("trying to get a key that doesn't exist");
        }
        try {
            int mike = aNewMap.get(null);
            System.out.println(mike);
        } catch (Exception e) {
            System.out.println("trying to get a null");
        }
        //same key different value
        try {
            int mike = aNewMap.put("joseph peterson", 3);
            System.out.println(mike);
        } catch (Exception e) {
            System.out.println("adding same key with different value");
        }
        //put a null
        try {
            int mike = aNewMap.put("null", null);
            System.out.println(mike);
        } catch (Exception e) {
            System.out.println("adding null key and null value");
        }

        System.out.println(aNewMap);


    }
}
