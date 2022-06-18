package ch.bzz.model.company;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * The Model-Class Teams is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 */
public class Teams {
    private List<String> designations;

    public Teams() {
        designations=new ArrayList<String>();
    }

    public String getDesignation(int index) {
        return designations.get(index);
    }

    public void setDesignation(int index,String designation) {
        designations.set(index,designation);
    }


    public void addDesignation(String designation) {
        designations.add(designation);
    }

    public void removeDesignation(int index) {
        designations.remove(index);
    }

    public List<String> getListOfTeams(){
        return designations;
    }

    public void setListOfTeams(List<String> designations){
        this.designations=designations;
    }

    @JsonIgnore
    public int getSize(){
        return designations.size();
    }
}
