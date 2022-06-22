package ch.bzz.model.company;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * The Model-Class Teams is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 22.06.2022
 */
public class Teams {
    private List<String> designations;

    /**
     * Creates Teams
     */
    public Teams() {
        designations=new ArrayList<String>();
    }

    /**
     * gets a team designation
     *
     * @param index of designation
     * @return designation
     */
    public String getDesignation(int index) {
        return designations.get(index);
    }

    /**
     * sets the team designation
     *
     * @param index of team designation
     * @param designation value of designation
     */
    public void setDesignation(int index,String designation) {
        designations.set(index,designation);
    }

    /**
     * add a new designation
     *
     * @param designation value of a designation
     */
    public void addDesignation(String designation) {
        designations.add(designation);
    }

    /**
     * removes a team
     *
     * @param index removes this designation
     */
    public void removeDesignation(int index) {
        designations.remove(index);
    }

    /**
     * gets all Teams
     *
     * @return list of teams
     */
    public List<String> getListOfTeams(){
        return designations;
    }

    /**
     * sets all teams
     *
     * @param designations list of teams
     */
    public void setListOfTeams(List<String> designations){
        this.designations=designations;
    }

    /**
     * look if a designation exist
     *
     * @param designation value of searching designation
     * @return if it exists
     */
    public boolean contains(String designation){
        return designations.contains(designation);
    }

    /**
     * get amount of teams
     *
     * @return amount of teams
     */
    @JsonIgnore
    public int getSize(){
        return designations.size();
    }
}
