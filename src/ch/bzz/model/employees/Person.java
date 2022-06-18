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

    public Person(@JsonProperty("firstName")String firstName,@JsonProperty("lastName") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        participation=new Participation();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Participation getParticipation() {
        return participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    @JsonIgnore
    public String getFullName() {
        return firstName+" "+lastName;
    }

    @Override
    public int compareTo(Object obj) {
        Person person2=(Person)obj;
        return this.getFullName()   .compareTo(   person2.getFullName());
    }
}
