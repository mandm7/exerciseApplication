package mikecoleman.json;

import mikecoleman.mvc.MyPersonBean;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONUtilities;


/**
 * Created by Mike Coleman on 11/17/2015.
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








        /*********************************NASTY PATHS*****************************************/


    }
}
