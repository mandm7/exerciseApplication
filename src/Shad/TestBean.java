package Shad;

import java.io.Serializable;

/**
 * Created by Shad on 10/14/2015.
 */
public class TestBean implements Serializable {
    private String FirstName;
    private String LastName;
    private int    BirthMonth;
    private int    BirthDay;
    private int   BirthYear;

    public TestBean(String FirstName, String LastName, int BirthMonth, int BirthDay, int BirthYear){

        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BirthMonth = BirthMonth;
        this.BirthDay = BirthDay;
        this.BirthYear = BirthYear;

    }
    public TestBean(){

    }
    public String getFirstName(){return FirstName;}

    public void setFirstName(String FirstName){this.FirstName = FirstName;}

    public String getLastName(){return LastName;}

    public void setLastName(){this.LastName = FirstName;}

    public int getBirthMonth(){return BirthMonth;}

    public void setBirthMonth(int BirthMonth){this.BirthMonth = BirthMonth;}

    public int getBirthDay(){return BirthDay;}

    public void setBirthDay(int BirthDay){this.BirthDay = BirthDay;}

    public int getBirthYear(){return BirthYear;}

    public void setBirthYear(int BirthYear){this.BirthYear = BirthYear;}
}
