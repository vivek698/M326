package ch.bzz.model.employees;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 *
 *
 * @version 1.0
 */
/* start @author Lorenzo Giuntini (Medox36) */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HRPerson.class)})
/* end @author Lorenzo Giuntini (Medox36) */
public class Person {
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
}
