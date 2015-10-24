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
        TreeMap<Integer, String> aMap = new TreeMap<>();
        aMap.put(6, "More Maps");
        aMap.put(5, "Maps");

        System.out.println(aMap.firstKey());
        System.out.println(aMap);


        //nasty path
        TreeMap<String, Integer> aTree = new TreeMap<>();

        try {
            aTree.lastKey();
        } catch(Exception e){
            System.out.println("There is no key found in the TreeMap");
        }
    }
}
