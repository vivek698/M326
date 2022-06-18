package ch.bzz.model.employees;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * The Model-Class Participation is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 */
public class Participation {
    private List<String> jobFunctions;
    private List<String> teams;

    public Participation() {
        jobFunctions =new ArrayList<>();
        teams=new ArrayList<>();
    }

    public String getFunction(int index) {
        return jobFunctions.get(index);
    }

    public void addFunction(String function) {
        jobFunctions.add(function);
    }

    public void removeFunction(int index) {
        jobFunctions.remove(index);
    }

    public void removeFunction(String function) {
        jobFunctions.remove(function);
    }

    public List<String> getListOfJobFunctions(){
        return jobFunctions;
    }

    public void setListOfJobFunctions(List<String> jobFunctions){
         this.jobFunctions=jobFunctions;
    }

    @JsonIgnore
    public int getNumberOfFunction(){
        return jobFunctions.size();
    }




    public String getTeams(int index) {
        return teams.get(index);
    }

    public void addTeams(String team) {
        teams.add(team);
    }

    public void removeTeams(int index) {
        teams.remove(index);
    }

    public void removeTeams(String team) {
        teams.remove(team);
    }

    public List<String> getListOfTeams(){
        return teams;
    }

    public void setListOfTeams(List<String> teams){
        this.teams=teams;
    }

    @JsonIgnore
    public int getNumberOFTeams(){
        return teams.size();
    }
}
