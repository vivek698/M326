package ch.bzz.model.employees;

import ch.bzz.model.log.LogBook;
import ch.bzz.model.log.UserAction;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

public class HRPerson extends Person{
    private int modus;
    private String pwd;
    //TODO ask Lorenzo
    public HRPerson(@JsonProperty("firstName")String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("modus")int modus) {
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
        LogBook log = LogBook.getLogBookInstance();
        String entry = ua.getEntry();
        log.addEntry(entry);
    }

}
