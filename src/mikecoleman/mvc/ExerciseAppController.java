package mikecoleman.mvc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Mike on 10/15/2015.
 * This class serves the purpose of Controller in the MVC pattern. This controller contains the following:
 * The start() method from main to being program execution
 * Scanner to get information from the user
 * Method to store information into a MyPersonBean
 * Method to add the created MyPersonBeans into an ArrayList
 */

public class ExerciseAppController {
    // Instantiate all necessary classes for controller to have access to all parts of the program
    private ExerciseAppView appView = new ExerciseAppView(this);
    private ExerciseAppModel appModel = new ExerciseAppModel();

    // Directly referenced from the ExerciseAppRunner main method to start program here
    public void start() {
        makePerson();
        appView.displayInformation();
    }

    // Method to create new users for the ExerciseApp
    public void makePerson() {

        // Change loop value for how many users you want to add
        for (int i = 0; i < 2; i++) {

            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your name");
            String name = input.nextLine();
            System.out.println("Please enter your email");
            String email = input.nextLine();
            System.out.println("Please enter your age");
            int age = input.nextInt();
            System.out.println("Please enter your height");
            int height = input.nextInt();
            System.out.println("Please enter your weight");
            int weight = input.nextInt();

            // Call storePerson method and pass in the user inputs
            this.storePerson(name, email, age, height, weight);
        }

    }

    // Method to store user input to create new instances of MyPersonBean, call addPerson method
    public void storePerson(String name, String email, int age, int height, int weight) {
        MyPersonBean newPerson = new MyPersonBean(name, email, age, height, weight);
        appModel.addPerson(newPerson);
    }

    // ArrayList of all created MyPersonBeans
    public ArrayList<MyPersonBean> getAllPersons() {
        return appModel.persons;
    }

}
