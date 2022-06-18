package ch.bzz.model.company;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * The Model-Class JobFunction is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 */
public class JobFunctions {
    private List<String> designations;

    public JobFunctions() {
        designations=new ArrayList<String>();
    }

    public String getDesignation(int index) {
        return designations.get(index);
    }

    public void setDesignation(int index,String designation) {
        designations.set(index,designation);
    }

    public void addDesignation(String name) {
        designations.add(name);
    }

    public void removeDesignation(int index) {
        designations.remove(index);
    }

    public List<String> getListOfJobFunctions(){
        return designations;
    }

    public void setListOfJobFunctions(List<String> designations){
        this.designations=designations;
    }

    @JsonIgnore
    public int getSize(){
        return designations.size();
    }
}
