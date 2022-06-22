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

    /**
     * creates a new Participation
     */
    public Participation() {
        jobFunctions =new ArrayList<>();
        teams=new ArrayList<>();
    }

    /**
     * gets a jobFunction
     * @param index of job function
     * @return job function
     */
    public String getFunction(int index) {
        return jobFunctions.get(index);
    }

    /**
     * adds a jobFunction
     *
     * @param function new function
     */
    public void addFunction(String function) {
        jobFunctions.add(function);
    }

    /**
     * removes a jobFunction
     *
     * @param index removes the jobfunction
     */
    public void removeFunction(int index) {
        jobFunctions.remove(index);
    }

    /**
     * removes a team
     *
     * @param function team which will be removed
     */
    public void removeFunction(String function) {
        jobFunctions.remove(function);
    }

    /**
     * gets all jobFunction
     *
     * @return list of all jobFunctions
     */
    public List<String> getListOfJobFunctions(){
        return jobFunctions;
    }

    /**
     * sets all teams
     *
     * @param jobFunctions list of teams
     */
    public void setListOfJobFunctions(List<String> jobFunctions){
         this.jobFunctions=jobFunctions;
    }

    /**
     * get Amounts of jobFunctions
     *
     * @return amount of jobFunctions
     */
    @JsonIgnore
    public int getNumberOfFunction(){
        return jobFunctions.size();
    }


    /**
     * gets Teams
     * @param index of team designation
     * @return team designation
     */
    public String getTeams(int index) {
        return teams.get(index);
    }

    /**
     * adds a team
     *
     * @param team new team
     */
    public void addTeams(String team) {
        teams.add(team);
    }

    /**
     * removes a team
     *
     * @param index removes this team
     */
    public void removeTeams(int index) {
        teams.remove(index);
    }

    /**
     * removes a team
     *
     * @param team team which will be removed
     */
    public void removeTeams(String team) {
        teams.remove(team);
    }

    /**
     * gets all teams
     *
     * @return list of all teams
     */
    public List<String> getListOfTeams(){
        return teams;
    }

    /**
     * sets all teams
     *
     * @param teams list of teams
     */
    public void setListOfTeams(List<String> teams){
        this.teams=teams;
    }

    /**
     * get Amounts of teams
     *
     * @return amount of teams
     */
    @JsonIgnore
    public int getNumberOFTeams(){
        return teams.size();
    }
}
