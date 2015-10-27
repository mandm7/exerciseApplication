package joseph.peterson.MVC;

import java.util.ArrayList;

/**
 * Created by Joseph on 10/13/2015.
 */
public class ExerciseAppController {
    //create instance for class
    private ExerciseAppModel theModel = new ExerciseAppModel();
    //create method
    public void storePerson(String name, String email, int age, int height, int weight ){
        //we can say PersonBean here because we made a constructor in PersonBean class.
        PersonBean personOne = new PersonBean(name, email, age, height, weight);
        theModel.addPerson(personOne);
    }


    public ArrayList<PersonBean> getAllPersons(){
        return theModel.getPersons();
    }
}
