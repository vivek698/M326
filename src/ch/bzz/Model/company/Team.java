package ch.bzz.Model.company;

import ch.bzz.Model.employees.Person;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Person> members;

    public Team(String name) {
        this.name=name;
        members=new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public Person getMember(int index) {
        return members.get(index);
    }

    public void addMember(Person person) {
        person.getParticipation().addTeams(this);
        members.add(person);
    }

    public void removeMember(int index) {
        members.get(index).getParticipation().removeTeams(this);
        members.remove(index);
    }

    public int getSize(){
        return members.size();
    }
}
