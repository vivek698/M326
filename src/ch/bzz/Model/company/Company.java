package ch.bzz.Model.company;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<JobFunction> jobFunctions;
    private ArrayList<Team> teams;

    public Company(String name) {
        this.name = name;
        departments=new ArrayList<>();
        jobFunctions=new ArrayList<>();
        teams =new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Department getDepartment(int index) {
        return departments.get(index);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(int index) {
        departments.remove(index);
    }

    public int getNumberOfDepartment(){
        return departments.size();
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

    public int getNumberOFTeams(){
        return teams.size();
    }
}
