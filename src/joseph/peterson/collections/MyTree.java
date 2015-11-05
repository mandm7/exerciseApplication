package joseph.peterson.collections;

import java.util.TreeMap;

/**
 * Created by Joseph on 10/20/2015.
 */
public class MyTree {
    public static void main(String[] args) {
        MyTree aTree = new MyTree();
        aTree.runThis();
    }
    public void runThis(){
        //////////////////////////////////////////HAPPY PATHS////////////////////////////////////////////////////
        TreeMap<Integer, String> aMap = new TreeMap<>();
        aMap.put(6, "More Maps");
        aMap.put(5, "Maps");
        aMap.put(9, "this is nine");

        System.out.println(aMap.firstKey());
        System.out.println(aMap);
        System.out.println(aMap.lastKey());
        System.out.println(aMap.descendingKeySet());



        //////////////////////////////////////////NASTY PATHS///////////////////////////////////////////////////
        //adding a null is redundant.
        try {
            aMap.put(null,null);
        }catch (Exception e){
            System.out.println("its stupid to add key and value of null");
        }
        //add what already exists doesn't do anything
        aMap.put(6, "More Maps");
        //getting what doesnt exist.
        aMap.get("does not exist");
        System.out.println(aMap);
    }
}
