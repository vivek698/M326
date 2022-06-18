package ch.bzz.model.company;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class JobFunctions {
    private List<String> designations;

    public JobFunctions() {
        designations = new ArrayList<String>();
    }

    public String getDesignation(int index) {
        return designations.get(index);
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

    public void setDesignation(String name, int index){
        designations.set(index, name);
    }

    @JsonIgnore
    public int getSize(){
        return designations.size();
    }

}
