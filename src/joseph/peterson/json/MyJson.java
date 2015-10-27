package joseph.peterson.JSON;


import joseph.peterson.MVC.ExerciseAppController;
import joseph.peterson.MVC.PersonBean;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONUtilities;
import joseph.peterson.MVC.ExerciseAppController;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Joseph on 10/20/2015.
 */
public class MyJson implements Serializable{
    private ExerciseAppController controller = new ExerciseAppController();

    public static void main(String[] args) {

        MyJson jason = new MyJson();
        jason.goBaby();
    }

    public void goBaby() {
//        ArrayList<PersonBean> beanString = controller.getAllPersons;
//        try {
//            String stringMyBean = JSONUtilities.stringify(beanString);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }
}