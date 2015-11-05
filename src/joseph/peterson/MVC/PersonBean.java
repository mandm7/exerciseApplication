package joseph.peterson.MVC;

import java.io.Serializable;

/**
 * Created by Joseph on 10/7/2015.
 */
public class PersonBean implements Serializable {
    //These are private because once the user enters this data, it is not to be messed with.
    private String name;
    private String email;
    private int age;
    private int height;
    private int weight;
    //This is the object
    public PersonBean(String name, String email, int age, int height, int weight) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
        this.weight = weight;

    }
    //constructor makes it easier to create instances.
    //default constructor. We don't need defaults for person since every person is different.
    public PersonBean(){
    }
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
