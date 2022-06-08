package ch.bzz.Model.employees;

import ch.bzz.Model.company.JobFunction;
import ch.bzz.Model.company.Team;

import java.util.ArrayList;

public class Participation {
    private Person owner;
    private ArrayList<JobFunction> jobFunctions;
    private ArrayList<Team> teams;

    public Participation(Person owner) {
        this.owner = owner;
        jobFunctions =new ArrayList<>();
        teams=new ArrayList<>();
        owner.setParticipation(this);
    }

    public JobFunction getFunction(int index) {
        return jobFunctions.get(index);
    }

    public void addFunction(JobFunction function) {
        jobFunctions.add(function);
    }

    public void removeFunction(int index) {
        jobFunctions.remove(index);
    }

    public void removeFunction(JobFunction function) {
        jobFunctions.remove(function);
    }

    public int getNumberOfFunction(){
        return jobFunctions.size();
    }

    public Team getTeams(int index) {
        return teams.get(index);
    }

    public void addTeams(Team function) {
        teams.add(function);
    }

    public void removeTeams(int index) {
        teams.remove(index);
    }

    public void removeTeams(Team team) {
        teams.remove(team);
    }

    public int getNumberOFTeams(){
        return teams.size();
    }
}
