package joseph.peterson;

import java.util.ArrayList;


/**
 * Created by Joseph on 10/7/2015.
 */
public class ExerciseAppModel {
    //This class will hold an array list and
    //the methods to add or remove a person or get all persons
    ArrayList<PersonBean> persons = new ArrayList<>();
    public void addPerson(PersonBean aPerson){
        this.persons.add(aPerson);

    }
    //do I need to use the toString method?
    public ArrayList<PersonBean> getPersons(){
        return this.persons;
    }


}
