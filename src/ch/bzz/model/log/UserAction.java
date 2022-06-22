package ch.bzz.model.log;

import ch.bzz.model.employees.HRPerson;
import ch.bzz.model.employees.Person;

import java.time.LocalDate;


public class UserAction {
    public static int CREATE_PERSON = 0;
    public static int CHANGE_VALUE = 1;
    public static int SET_ASSIGNMENT = 2;
    public static int DELETE_PERSON = 3;
    private String[] actionDescription = {"CREATE_PERSON", "CHANGE_VALUE", "SET_ASSIGNMENT", "DELETE_PERSON"};
    private String entry;

    /**
     * Constructor
     * @param hrPerson who made the Action
     * @param person where is the Action
     * @param action what is the Action
     */
    public UserAction(HRPerson hrPerson, Person person, int action){
        entry = LocalDate.now()+": ";
        entry += hrPerson.getFirstName()+" ";
        entry += hrPerson.getLastName()+";";

        if (action >= 0 && action < actionDescription.length){
            entry += actionDescription[action]+": ";
            entry += person.getFirstName()+" ";
            entry += person.getLastName()+";";
        }else{
            entry+="unknown action";
        }
    }

    /**
     * gets a Entry
     * @return entry
     */
    public String getEntry() {
        return entry;
    }

    /**
     * sets a Entry
     * @param entry
     */
    public void setEntry(String entry) {
        this.entry = entry;
    }
}
