package joseph.peterson.collections;


import java.util.ArrayList;

/**
 * Created by Joseph on 10/27/2015.
 */
public class MyArrayList {
    public static void main(String[] args) {
        MyArrayList aRandomList = new MyArrayList();
        aRandomList.run();
    }
    public void run(){
        ////////////////////////////////////////////////HAPPY PATHS///////////////////////////////////////////
        ArrayList<Integer> anArrayList = new ArrayList();
        anArrayList.add(1);
        anArrayList.add(2);
        anArrayList.add(3);
        anArrayList.add(4);
        System.out.println(anArrayList);
        System.out.println(anArrayList.get(2));

        System.out.println(anArrayList);
        anArrayList.remove(3);



        //////////////////////////////////////////////NASTY PATHS//////////////////////////////////////////////
        try {
            //adding to index that doesn't exist.
            anArrayList.add(50, 3);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("cant add to non existant index");
        }
        try {
            //trying to remove index that doesnt exist
            anArrayList.remove(4);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("cant remove index that doesnt exist.");
        }
        //remove -5
        try {
            anArrayList.remove(-5);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("cant remove negative index");
        }
        //add null

        anArrayList.add(null);
        System.out.println(anArrayList);


    }
}
