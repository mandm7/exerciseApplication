package mikecoleman.mvc;

import java.io.Serializable;

/**
 * Created by Mike on 10/15/2015.
 * This class is just a JavaBean for users created within the application
 */
public class MyPersonBean implements Serializable {

    private String name;
    private String email;
    private int age;
    private int height;
    private int weight;

    public MyPersonBean(String name, String email, int age, int height, int weight) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    // This is a toString() override to help us display the information found within the MyPersonBeans
    @Override
    public String toString() {
        return "MyPersonBean{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public MyPersonBean() {
    }

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
