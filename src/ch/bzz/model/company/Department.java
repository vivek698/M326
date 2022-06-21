package ch.bzz.model.company;

import ch.bzz.model.employees.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The Model-Class Department is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 */
public class Department {
    private String name;
    private List<Person> members;

    /**
     * Creates a department
     * @param name value of name
     */
    public Department(@JsonProperty("name")String name) {
        this.name=name;
        members=new ArrayList<Person>();
    }

    /**
     * gets name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     *
     * @param name value of name
     */
    public void setName(String name) {
        this.name=name;
    }

    /**
     * get a Member
     *
     * @param index of a Member
     * @return member
     */
    public Person getMember(int index) {
        return members.get(index);
    }

    /**
     * adds a Member
     *
     * @param person value of member
     */
    public void addMember(Person person) {
        members.add(person);
    }

    /**
     * removes a member
     *
     * @param index of a member
     */
    public void removeMember(int index) {
        members.remove(index);
    }

    /**
     * get all Members
     *
     * @return all Members
     */
    public List<Person> getListOfPersons(){
        return members;
    }

    /**
     * sets all Persons
     *
     * @param allPerson value of members
     */
    public void setListOfPersons(List<Person> allPerson){
        this.members=allPerson;
    }

    /**
     * get amount of Members
     *
     * @return amount of Members
     */
    @JsonIgnore
    public int getNumberOfMembers(){
        return members.size();
    }
}
