package mikecoleman.mvc;

import java.util.ArrayList;

/**
 * Created by Mike on 10/19/2015.
 * This class serves the purpose of a Model in the MVC pattern.
 * It will hold an arrayList of PersonBeans for all people created as well as a method to add the PersonBeans to the ArrayList
 */

public class ExerciseAppModel {
    // Create arrayList called persons to hold all MyPersonBeans created
    private ArrayList<MyPersonBean> persons = new ArrayList<>();

    // Method to add a new MyPersonBean to the above arrayList
    public void addPerson(MyPersonBean aPerson) {
        this.persons.add(aPerson);
    }

    public ArrayList<MyPersonBean> getAllPersons(){
        return persons;
    }
}
