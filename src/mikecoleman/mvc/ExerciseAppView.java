package mikecoleman.mvc;

import java.util.ArrayList;

/**
 * Created by Mike on 10/15/2015.
 * This class will serve the purpose of a View in the mymvc pattern.
 * It will communicate with the controller to display information found in the model
 */

public class ExerciseAppView {
    // Instantiate the ExerciseAppController class to be able to communicate and update views from the model information
    private ExerciseAppController appController;

    public ExerciseAppView(ExerciseAppController appController) {
        this.appController = appController;
    }

    // Method to display all MyPersonBeans found in the ArrayList
    public void displayInformation(ArrayList<MyPersonBean> people) {
        System.out.println(people);
    }

}
