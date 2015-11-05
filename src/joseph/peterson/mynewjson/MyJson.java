package joseph.peterson.mynewjson;


import joseph.peterson.mymvc.PersonBean;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Joseph on 10/20/2015.
 */

//don't use object input. it does binary
public class MyJson{

    public static void main(String[] args) {

        MyJson jason = new MyJson();
        jason.go();
    }

    public void go() {
        //////////////////////////////////////////////HAPPY PATHS//////////////////////////////////////////////////////
        ArrayList<String> myJson= new ArrayList();
        myJson.add("Mike");
        myJson.add("Joseph");
        myJson.add("Shad");

        //stringifying ArrayList using json utilities
        try {
            String jList = JSONUtilities.stringify(myJson);
            System.out.println(jList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //parses json string to hashmap
        try {
            //create the string
            String jsonString = "{\"My Converted String\":\"This has been parsed to hashmap.\",\"theInt\":\"7\",\"theDate\":\"Wed Dec 31 17:17:47 MST 1969\"}";
            //create the map to hold string
            HashMap aMap = (HashMap)JSONUtilities.parse(jsonString);
            //get key from map and store in variable
            String aString = (String)aMap.get("My Converted String");
            //print out the value of the key.
            System.out.println(aString);
            //print out the whole hashmap
            System.out.println(aMap);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> myHashMap = new HashMap<>();
        myHashMap.put("joseph", 26);
        myHashMap.put("Shad", 27);
        myHashMap.put("Mike", 26);

        //stringifying HashMap
        try {
            String jMap = JSONUtilities.stringify(myHashMap);
            System.out.println(jMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Using mynewjson OUTPUT STREAM CLASS
        //first bring in a bean and create a new one
        PersonBean newBean = new PersonBean("Joseph","japeter89@gmail.com", 26, 5, 160);
        //now write that object to a file
        File firstFile = new File("firstFile.json");
        try {
            FileOutputStream myFileOutputStream = new FileOutputStream(firstFile);
            JSONOutputStream myJsonOutput = new JSONOutputStream(myFileOutputStream);
            myJsonOutput.writeObject(newBean);
            myJsonOutput.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //Using mynewjson INPUT STREAM CLASS

        File secondFile = new File("secondFile.json");
        try {
            FileInputStream myFileStream = new FileInputStream(secondFile);
            JSONInputStream objectIn = new JSONInputStream(myFileStream);
            PersonBean aPerson = (PersonBean)objectIn.readObject();
            objectIn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ////////////////////////////////////////////////NASTY PATHS///////////////////////////////////////////////////
        //read json that isn't a string
        try {
            //create the string
            String jsonString = "this is going to throw some exception";
            //create the map to hold string
            HashMap aMap = (HashMap)JSONUtilities.parse(jsonString);
            //print out the whole hashmap
            System.out.println(aMap);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        //stringifying null using json
        try {
            String jList = JSONUtilities.stringify(null);
            System.out.println(jList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //parse null
        try {
            //create the string
            String jsonString = "{\"My Converted String\":\"This has been parsed to hashmap.\",\"null\":\"null\",\"theDate\":\"Wed Dec 31 17:17:47 MST 1969\"}";
            //create the map to hold string
            HashMap aMap = (HashMap)JSONUtilities.parse(null);
            //print out the whole hashmap
            System.out.println(aMap);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        //parses json string with null key and null value to hashmap
        try {
            //create the string
            String jsonString = "{\"My Converted String\":\"This has been parsed to hashmap.\",\"null\":\"null\",\"theDate\":\"Wed Dec 31 17:17:47 MST 1969\"}";
            //create the map to hold string
            HashMap aMap = (HashMap)JSONUtilities.parse(jsonString);
            //get key from map and store in variable
            String aString = (String)aMap.get("null");
            //print out the value of the key.
            System.out.println(aString);
            //print out the whole hashmap
            System.out.println(aMap);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        //adding null to object to write to file
        PersonBean anotherBean = new PersonBean("mike",null,5,5,5);
        File thirdFile = new File("thirdFile.json");
        try {
            FileOutputStream myFileOutputStream = new FileOutputStream(thirdFile);
            JSONOutputStream myJsonOutput = new JSONOutputStream(myFileOutputStream);
            myJsonOutput.writeObject(newBean);
            myJsonOutput.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //write to file with revoked privileges
        File lastFile = new File("lastFile.json");

        try {
            FileOutputStream aFileStream = new FileOutputStream(lastFile);
            JSONOutputStream jsonOUT = new JSONOutputStream(aFileStream);
            //tells to write and which object will be written
            jsonOUT.writeObject(newBean);
            jsonOUT.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //read file with revoked privileges
        File veryLastFile = new File("veryLastFile.json");
        try {
            FileInputStream myFileStream = new FileInputStream(veryLastFile);
            JSONInputStream objectIn = new JSONInputStream(myFileStream);
            PersonBean aPerson = (PersonBean)objectIn.readObject();
            objectIn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //pass null to already created json object

        try {
            FileOutputStream myFileOutputStream = new FileOutputStream(lastFile);
            JSONOutputStream myJsonOutput = new JSONOutputStream(myFileOutputStream);
            myJsonOutput.writeObject(null);
            System.out.println(myJsonOutput);
            myJsonOutput.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //read null from already created json object
        try {
            FileInputStream myFileStream = new FileInputStream(lastFile);
            JSONInputStream objectIn = new JSONInputStream(myFileStream);
            objectIn.readObject();
            System.out.println(objectIn);
            objectIn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}