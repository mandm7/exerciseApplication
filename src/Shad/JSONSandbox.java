package Shad;

import joseph.peterson.mymvc.PersonBean;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.FileInputStream;


/**
 * Created by Shad on 10/14/2015.
 */

// ------------------------------WORKING EXAMPLES OF mynewjson --------------------------------------
public class JSONSandbox implements Serializable{
 public static void main(String[] args) throws JSONException {
// extracts PersonBean and adds the mynewjson parameters
     PersonBean newBean = new PersonBean("Shad", "sbstanger@gmail.com", 28, 6, 175);
     try {
         String jsonString = JSONUtilities.stringify(newBean);
         System.out.println(jsonString);
     } catch (JSONException e) {
         e.printStackTrace();
     }
     // extracts TestBean and adds the mynewjson parameters, has null value to show the null ability.
     TestBean newerBean = new TestBean("Shad", "Stanger", 8, 10, 1988);
     try {
         String jsonString = JSONUtilities.stringify(newerBean);
         System.out.println(jsonString);
     } catch (JSONException e) {
         e.printStackTrace();
     }
     //creates and specifies the path of where the file will be stored
     File aFile = new File("C:\\Users\\Shad\\test\\test.txt");
     //writes the string to the .txt file
     try {
         FileOutputStream aFileStream = new FileOutputStream(aFile);
         JSONOutputStream jsonOUT = new JSONOutputStream(aFileStream);
         //tells to write and which object will be written
         jsonOUT.writeObject(newerBean);
         jsonOUT.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
     // specifies where the file you want to be read is located
     File aFile2 = new File("C:\\Users\\Shad\\test\\test.txt");
     try {
         FileInputStream aFileStream2 = new FileInputStream(aFile2);
         JSONInputStream jsonIN = new JSONInputStream(aFileStream2);
         //uses hashmap to store the written object
         HashMap result = (HashMap) jsonIN.readObject();
         jsonIN.close();
         System.out.println(result);
     } catch (Exception e) {
         e.printStackTrace();
     }
/*
------------------------------------------------------------------------------
NASTY PATHS, INTENTIONAL BROKEN CODE
*/

     //runs when a null value is present in the string
     PersonBean new2Bean = new PersonBean("Shad", null, 8, 6, 75);
     try {
         String jsonString = JSONUtilities.stringify(new2Bean);
         System.out.println(jsonString);
     } catch (JSONException e) {
         e.printStackTrace();

     }
     try {
         String jsonString = JSONUtilities.stringify(null);
         System.out.println(jsonString);
     } catch (JSONException e) {
         e.printStackTrace();

     }
     try {
         String jsonString = JSONUtilities.stringify(5);
         System.out.println(jsonString);
     } catch (JSONException e) {
         e.printStackTrace();

     }
     try {
         String jsonString = JSONUtilities.stringify("Hello");
         System.out.println(jsonString);
     } catch (JSONException e) {
         e.printStackTrace();

     }
     try {
         String jsonString = JSONUtilities.stringify(new JButton());
         System.out.println("JButton:" + jsonString);
     } catch (JSONException e) {
         e.printStackTrace();
     }

     //----------------write nasty paths-------------------------------
     //attempting to write to a protected file where access is denied.
     File a2File = new File("C:\\Users\\Shad\\test2\\test.txt");
     //
     try {
         FileOutputStream aFileStream = new FileOutputStream(a2File);
         JSONOutputStream jsonOUT = new JSONOutputStream(aFileStream);
         //tells to write and which object will be written
         jsonOUT.writeObject(newerBean);
         jsonOUT.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
     File a3File = new File("C:\\Users\\Shad\\test\\berp.txt");
     //writes to an already existing file
     try {
         FileOutputStream aFileStream = new FileOutputStream(a3File);
         JSONOutputStream jsonOUT = new JSONOutputStream(aFileStream);
         //tells to write and which object will be written
         jsonOUT.writeObject(newBean);
         jsonOUT.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
     //overwrites file with the current string


     //-----------------read nasty paths-------------------------------
     //when a file that isn't supported is read
     File a2File2 = new File("C:\\Users\\Shad\\test\\test.html");
     try {
         FileInputStream aFileStream2 = new FileInputStream(a2File2);
         JSONInputStream jsonIN = new JSONInputStream(aFileStream2);
         //uses hashmap to store the written object
         HashMap result = (HashMap) jsonIN.readObject();
         jsonIN.close();
         System.out.println(result);
     } catch (Exception e) {
         e.printStackTrace();
     }

     //when there isn't a file isn't present to be read
     File a3File2 = new File("C:\\Users\\Shad\\test\\meep.txt");
     try {
         FileInputStream aFileStream2 = new FileInputStream(a3File2);
         JSONInputStream jsonIN = new JSONInputStream(aFileStream2);
         //uses hashmap to store the written object
         HashMap result = (HashMap) jsonIN.readObject();
         jsonIN.close();
         System.out.println(result);
     } catch (Exception e) {
         e.printStackTrace();
     }
     // reads file a second time
     try {
         FileInputStream aFileStream = new FileInputStream(aFile);
         JSONInputStream jsonIN = new JSONInputStream(aFileStream);
         //uses hashmap to store the written object
         HashMap result = (HashMap) jsonIN.readObject();
         jsonIN.close();
         System.out.println(result);
     } catch (Exception e) {
         e.printStackTrace();
     }
     //Simply reads the file again
 }

     }

