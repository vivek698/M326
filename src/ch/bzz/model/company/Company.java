package ch.bzz.model.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;
    private List<Department> departments;
    private JobFunctions jobFunctions;
    private Teams teams;


    public Company(@JsonProperty("name") String name) {
        this.companyName = name;
        departments=new ArrayList<>();
        jobFunctions=new JobFunctions();
        teams =new Teams();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    @JsonIgnore
    public int getNumberOfDepartment(){
        return departments.size();
    }

    public List<Department> getListofDepartment(){
        return departments;
    }

    public void setListofDepartment(List<Department> departments){
        this.departments = departments;
    }



    public Teams getTeams(){
        return teams;
    }

    public void setTeams(Teams teams){
        this.teams=teams;
    }

    public String getTeams(int index) {
        return teams.getDesignation(index);
    }

    public void addTeams(String  function) {
        teams.addDesignation(function);
    }

    public void removeTeams(int index) {
        teams.removeDesignation(index);
    }

    @JsonIgnore
    public int getNumberOfTeams(){
        return teams.getSize();
    }




    public JobFunctions getJobFunctions(){
        return jobFunctions;
    }

    public void setJobFunctions( JobFunctions jobFunctions){
        this.jobFunctions=jobFunctions;
    }

    public String getJobFunction(int index) {
        return jobFunctions.getDesignation(index);
    }

    public void addJobFunction(String  function) {
        jobFunctions.addDesignation(function);
    }

    public void removeJobFunction(int index) {
        jobFunctions.removeDesignation(index);
    }

    @JsonIgnore
    public int getNumberOfJobFunction(){
        return jobFunctions.getSize();
    }
}
