package ch.bzz.model.employees;

import ch.bzz.model.log.LogBook;
import ch.bzz.model.log.UserAction;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

/**
 * The Model-Class HR-PersonView is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 */
public class HRPerson extends Person{
    private int mode;
    private String password;

    /**
     * create HR-Person
     * @param firstName value of first name
     * @param lastName value of last name
     * @param mode value of modus
     */
    public HRPerson(@JsonProperty("firstName")String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("mode")int mode) {
        super(firstName, lastName);
        this.mode = mode;
    }

    /**
     * gets the mode
     *
     * @return mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * sets the mode
     *
     * @param mode value of mode
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    /**
     * gets the password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the passwort
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * writes the log Entry
     * @param action action that was made
     * @param person who has done it
     * @throws IOException
     */
    public void writeLogEntry(int action, Person person) throws IOException {
        UserAction ua = new UserAction(this, person, action);
        LogBook log = LogBook.getLogBookInstance();
        String entry = ua.getEntry();
        log.addEntry(entry);
    }

    /**
     * Converts a HRPerson to a Person
     * @return converted Person
     */
    public Person convertToPerson(){
        return new Person(this.getFirstName(),this.getLastName());
    }



}
