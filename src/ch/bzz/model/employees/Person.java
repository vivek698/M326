package ch.bzz.model.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * The Model-Class Person is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HRPerson.class)})
public class Person  implements Comparable{
    private String firstName;
    private String lastName;

    //TODO decide
    private String photoPath;

    private Participation participation;

    /**
     * Creates Person
     * @param firstName value of firstname
     * @param lastName value of lastname
     */
    public Person(@JsonProperty("firstName")String firstName,@JsonProperty("lastName") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        participation=new Participation();
    }

    /**
     * gets first Name
     *
     * @return first Name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets first Name
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets last Name
     *
     * @return last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets last Name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets Participation
     *
     * @return Paricipation
     */
    public Participation getParticipation() {
        return participation;
    }

    /**
     * sets Participation
     *
     * @param participation
     */
    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    /**
     * gets the fullname
     *
     * @return prename name
     */
    @JsonIgnore
    public String getFullName() {
        return firstName+" "+lastName;
    }

    /**
     * Compares this persons full Name with an others
     *
     * @param obj is the other person
     * @return smaller = -1, same = 0, or greater = 1
     */
    @Override
    public int compareTo(Object obj) {
        Person person2=(Person)obj;
        return this.getFullName()   .compareTo(   person2.getFullName());
    }
}