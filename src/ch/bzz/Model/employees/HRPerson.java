package ch.bzz.Model.employees;

import ch.bzz.Model.log.LogBook;
import ch.bzz.Model.log.UserAction;

import java.io.IOException;

public class HRPerson extends Person{
    private int modus;
    private String pwd;

    public HRPerson(String firstName, String lastName,int modus) {
        super(firstName, lastName);
        this.modus = modus;
    }


    public void change(Person person, int modus){
        //TODO
    }

    public int getModus() {
        return modus;
    }

    public void setModus(int modus) {
        this.modus = modus;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void writeLogEntry(int action, Person person) throws IOException {
        UserAction ua = new UserAction(this, person, action);
        LogBook log = LogBook.getLogBookInstace();
        String entry = ua.getEntry();
        log.addEntry(entry);
    }

}
