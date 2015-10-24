package joseph.peterson.collections;

import java.util.HashMap;

/**
 * Created by Joseph on 10/20/2015.
 */

//HashMaps have key value.
public class MyMap {
    public static void main(String[] args) {
        MyMap run = new MyMap();
        run.Map();
    }
    public void Map(){
        HashMap<String, Integer> aNewMap = new HashMap<>();
        aNewMap.put("yo",7);
        System.out.println("In here is :" + aNewMap);
        if (!aNewMap.isEmpty()){
            aNewMap.clear();
            System.out.println("We deleted what was in here.");
        }else {

            System.out.println("nothing here to begin with");
        }
        System.out.println("now we have " + aNewMap.clone());


    }
}
