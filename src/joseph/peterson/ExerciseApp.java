package joseph.peterson;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseApp{
    //this instance is what is used to pass a message to another class's method.
    private ExerciseAppController controller = new ExerciseAppController();
    //This is the main method which is not object oriented so we want to get out of it as soon as possible.
    public static void main(String[]args){
        //this is an instance that is used to give a message to the go method to run it.
        ExerciseApp theApp = new ExerciseApp();
        //this calls the go method using the instance we created above
        theApp.go();
    }

    public void go(){


        for (int i = 0; i < 2; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your name");
            String name = in.nextLine();

            System.out.println("Enter your email");
            String email = in.nextLine();

            System.out.println("Enter your age");
            int age = in.nextInt();

            System.out.println("Enter your height");
            int height = in.nextInt();

            System.out.println("Enter your weight");
            int weight = in.nextInt();

            //Below is what im going to do with the information that was inputted.
            controller.storePerson(name, email, age, height, weight);


        }
        ArrayList<PersonBean> allPeople = controller.getAllPersons();
        System.out.println(allPeople);

    }



}
