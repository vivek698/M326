package ch.bzz.Model.employees;

public class Person {
    private String firstName;
    private String lastName;

    //TODO decide
    private String photoPath;

    private Participation participation;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        participation=new Participation(this);
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
