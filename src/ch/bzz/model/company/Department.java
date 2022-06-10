package ch.bzz.model.company;

import ch.bzz.model.employees.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Person> members;

    public Department(@JsonProperty("name")String name) {
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
        members.add(person);
    }

    public void removeMember(int index) {
        members.remove(index);
    }

    public List<Person> getListOfPersons(){
        return members;
    }

    public void setListOfPersons(List<Person> members){
        this.members=members;
    }

    @JsonIgnore
    public int getSize(){
        return members.size();
    }
}
