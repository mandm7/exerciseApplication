package mikecoleman.json;

import mikecoleman.mvc.MyPersonBean;
import org.quickconnectfamily.json.*;

import java.io.*;
import java.util.HashMap;


/**
 * Created by Mike Coleman on 11/17/2015.
 * Sandbox code with happy and nasty paths for json (javascript object notation)
 */
public class JsonPractice {
    public static void main(String[] args) {

        /*********************************HAPPY PATHS*****************************************/

        // Create new instance of MyPersonBean and stringify it via JSONUtilities
        MyPersonBean aPersonBean = new MyPersonBean("Joe", "joe@email.com", 22, 170, 165);
        try {
            String jsonString = JSONUtilities.stringify(aPersonBean);
            System.out.println(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            // Create String of data to be parsed into a new HashMap
            String stringToMap = "{\"numberOne\":1,\"numberTwo\":\"can be string\",\"numberThree\":true}";
            // Create HashMap to store the previously created data in stringToMap created above
            HashMap jsonMap = (HashMap) JSONUtilities.parse(stringToMap);
            // Show a value from a requested key
            System.out.println((String) jsonMap.get("numberTwo"));
            // Show all key value pairs within the created HashMap
            System.out.println(jsonMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Create file jsonFile1.json
        File jsonFile1 = new File("jsonFile1.json");
        // Use json to write the info created in aPersonBean we created at the beginning of this class
        try {
            FileOutputStream someOutputStream = new FileOutputStream(jsonFile1);
            JSONOutputStream someJsonOutput = new JSONOutputStream(someOutputStream);
            someJsonOutput.writeObject(aPersonBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create file jsonFile2.json
        File jsonFile2 = new File("jsonFile2.json");
        try {
            FileInputStream someInputStream = new FileInputStream(jsonFile2);
            JSONInputStream someJsonInput = new JSONInputStream(someInputStream);
            // Create a HashMap to store the data read in from the file
            HashMap personMap = (HashMap) someJsonInput.readObject();
            someJsonInput.close();
            // Prints all mappings found in the HashMap
            System.out.println(personMap.entrySet());
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*********************************NASTY PATHS*****************************************/

        try {
            // Create string in incorrect format for json to parse into a HashMap
            String notJsonString = "This is not a json String";
            // The attempted parse will throw a JSONException: Invalid mynewjson String
            HashMap testMap = (HashMap) JSONUtilities.parse(notJsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            // Create randomString and store stringify of null, null is printed out
            String randomString = JSONUtilities.stringify(null);
            System.out.println(randomString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            // Attempt to parse a null key and value set into a hashmap, throws JSONException: Invalid mynewjson String
            String anotherStringToMap = "{\"one:1\",\"two:2\",null:null,\"four:4\"}";
            HashMap thisMap = (HashMap)JSONUtilities.parse(anotherStringToMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MyPersonBean anotherPerson = new MyPersonBean(null,"j.halpert@theoffice.com", 37, 190, 170);
        File jsonFileWithNull = new File("jsonFileWithNull.json");
        /* Use json to write the info created in anotherPerson just created,
           file reads with a blank (null) where the null parameter was placed*/
        try {
            FileOutputStream anOutputStream = new FileOutputStream(jsonFileWithNull);
            JSONOutputStream aJsonOutput = new JSONOutputStream(anOutputStream);
            aJsonOutput.writeObject(anotherPerson);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create new file to which access will be denied
        File jsonRevokedPrivileges = new File("jsonRevokedPrivileges.json");
        try {
            /* Attempt to write to a file that we do not have rights to, throws
               java.io.FileNotFoundException: jsonRevokedPrivileges.json exception */
            FileOutputStream thisOutputStream = new FileOutputStream(jsonRevokedPrivileges);
            JSONOutputStream thisOutput = new JSONOutputStream(thisOutputStream);
            thisOutput.writeObject("some random junk");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            /* Attempt to read in the json String data from the same jsonRevokedPrivileges file created above
            throws java.io.FileNotFoundException: jsonRevokedPrivileges.json exception */
            FileInputStream someInputStream = new FileInputStream(jsonRevokedPrivileges);
            JSONInputStream someJsonInput = new JSONInputStream(someInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Write null to a file that already exists, file is overwritten as a blank file
        try {
            FileOutputStream moreOutputStream = new FileOutputStream(jsonFile1);
            JSONOutputStream moreJsonOutput = new JSONOutputStream(moreOutputStream);
            moreJsonOutput.writeObject(null);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
