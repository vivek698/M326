package ch.bzz.Model.log;

import ch.bzz.Model.employees.HRPerson;
import ch.bzz.Model.employees.Person;

public class UserAction {
    public static int CREATE_PERSON = 0;
    public static int CHANGE_VALUE = 1;
    public static int SET_ASSIGNEMENT = 2;
    public static int DELETE_PERSON = 3;
    private String[] actionDescription;
    private String entry;

    public UserAction(HRPerson hrPerson, Person person, int action){
        hrPerson.getModus();
        hrPerson.getLastName();

        if (action >= 0 && action < actionDescription.length){
            person.getFirstName();
            person.getLastName();
        }
    }

    public String getEntry() {
        return entry;
    }
}
