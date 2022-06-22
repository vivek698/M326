package ch.bzz.model.company;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * The Model-Class JobFunction is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 22.06.2022
 */
public class JobFunctions {
    private List<String> designations;


    /**
     * Creates JobFunctions
     */
    public JobFunctions() {
        designations=new ArrayList<String>();
    }

    /**
     * gets job functions
     *
     * @param index of a designation
     * @return designation
     */
    public String getDesignation(int index) {
        return designations.get(index);
    }

    /**
     * sets a job function
     *
     * @param index of a designation
     * @param designation value of designation
     */
    public void setDesignation(int index,String designation) {
        designations.set(index,designation);
    }

    /**
     * adds a new job function
     *
     * @param designation value of new designation
     */
    public void addDesignation(String designation) {
        designations.add(designation);
    }

    /**
     * removes a job function
     *
     * @param index
     */
    public void removeDesignation(int index) {
        designations.remove(index);
    }

    /**
     * gets all job function
     *
     * @return list of job functions
     */
    public List<String> getListOfJobFunctions(){
        return designations;
    }

    /**
     * sets all designations
     *
     * @param designations value of designation
     */
    public void setListOfJobFunctions(List<String> designations){
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
     * get amount of job function
     *
     * @return amount of job functions
     */
    @JsonIgnore
    public int getSize(){
        return designations.size();
    }
}
