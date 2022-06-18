package ch.bzz.model.company;

import ch.bzz.model.employees.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Model-Class Company is storing data.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 */
public class Company {
    private String companyName;
    private List<Department> departments;
    private JobFunctions jobFunctions;
    private Teams teams;

    /**
     * creates the Company
     *
     * @param name of the Company
     */
    public Company(@JsonProperty("name") String name) {
        this.companyName = name;
        departments=new ArrayList<>();
        jobFunctions=new JobFunctions();
        teams =new Teams();
    }

    /**
     * gets the Company Name
     *
     * @return companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * sets the Company Name
     *
     * @param companyName the value to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    /**
     * gets a department
     *
     * @param index of Department
     * @return department
     */
    public Department getDepartment(int index) {
        return departments.get(index);
    }

    /**
     * sets a department
     *
     * @param index of Department
     * @param department the value to set
     */
    public void setDepartment(int index,Department department) {
        departments.set(index,department);
    }

    /**
     * adds a department
     *
     * @param department the new department
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * removes a department
     *
     * @param index removes this department
     */
    public void removeDepartment(int index) {
        departments.remove(index);
    }

    /**
     * get amount of department
     *
     * @return amount of department
     */
    @JsonIgnore
    public int getNumberOfDepartment(){
        return departments.size();
    }

    /**
     * gets all departments
     *
     * @return list of departments
     */
    public List<Department> getListOfDepartment(){
        return departments;
    }

    /**
     * sets all departments
     *
     * @param departments the value to set
     */
    public void setListOfDepartment(List<Department> departments){
        this.departments = departments;
    }




    /**
     * get teams
     *
     * @return teams
     */
    public Teams getTeams(){
        return teams;
    }

    /**
     * set teams
     *
     * @param teams the value to set
     */
    public void setTeams(Teams teams){
        this.teams=teams;
    }

    /**
     * get team name
     *
     * @param index from the Team name
     * @return team name
     */
    public String getTeams(int index) {
        return teams.getDesignation(index);
    }

    /**
     * sets a team
     *
     * @param index of team
     * @param team the value to set
     */
    public void setTeams(int index,String team) {
        teams.setDesignation(index,team);
    }

    /**
     * adds a new team
     *
     * @param team the new team
     */
    public void addTeams(String team) {
        this.teams.addDesignation(team);
    }

    /**
     * removes a team
     *
     * @param index removes this team
     */
    public void removeTeams(int index) {
        teams.removeDesignation(index);
    }

    /**
     * get Amount of teams
     *
     * @return amount of teams
     */
    @JsonIgnore
    public int getNumberOfTeams(){
        return teams.getSize();
    }




    /**
     * get JobFunctions
     *
     * @return JobFunction
     */
    public JobFunctions getJobFunctions(){
        return jobFunctions;
    }

    /**
     * sets JobFunction
     *
     * @param jobFunctions the value to set
     */
    public void setJobFunctions(JobFunctions jobFunctions){
        this.jobFunctions=jobFunctions;
    }

    /**
     * get jobFunction designation
     *
     * @param index of the designation
     * @return jobFunction designation
     */
    public String getJobFunction(int index) {
        return jobFunctions.getDesignation(index);
    }

    /**
     * sets a jobFunction
     *
     * @param index of a jobFunction
     * @param jobFunction the value to set
     */
    public void setJobFunctions(int index,String jobFunction) {
        jobFunctions.setDesignation(index,jobFunction);
    }

    /**
     * adds a new jobFunction
     *
     * @param function the new jobFunction
     */
    public void addJobFunction(String  function) {
        jobFunctions.addDesignation(function);
    }

    /**
     * removes a jobFunction
     *
     * @param index remove this teams
     */
    public void removeJobFunction(int index) {
        jobFunctions.removeDesignation(index);
    }

    /**
     * gets amount of jobFunctions
     *
     * @return amount of jobFunctions
     */
    @JsonIgnore
    public int getNumberOfJobFunction(){
        return jobFunctions.getSize();
    }



    /**
     * get all Person of this Company
     *
     * @return list of all Person
     */
    @JsonIgnore
    public List<Person> getAllPerson(){
        ArrayList<Person> allPerson=new ArrayList<>();
        for (int i = 0; i < departments.size(); i++) {
            allPerson.addAll(departments.get(i).getListOfPersons());
        }
        return allPerson;
    }

    /**
     * get all Filters and
     * @param departmentName
     * @param function
     * @param teams
     * @param sortType
     * @return
     */
    public List<Person> getPersonFilteredAndSorted(String departmentName,String function, String teams,String sortType){
        List<Person> personList=getAllPerson();
        if (departmentName!=null){
            personList=filterListOfPersonByDepartment(departmentName);
        }else if(function!=null){
            personList=filterListOfPersonByFunction(personList,function);
        }else if (teams!=null){
            personList=filterListOfPersonByTeams(personList,teams);
        }else if (sortType!=null){
            sortListOfPerson(personList,sortType);
        }
        return personList;
    }



    private List<Person> filterListOfPersonByDepartment(String departmentName){
        for (Department department:departments) {
            if (department.getName().equals(departmentName)){
                return department.getListOfPersons();
            }
        }
        return null;
    }

    private List<Person> filterListOfPersonByFunction(List<Person> listOfPerson, String jobFunction){
        ArrayList<Person>filteredPerson=new ArrayList<>();
        for (Person person:listOfPerson) {
            if (person.getParticipation().getListOfJobFunctions().contains(jobFunction)){
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }

    private List<Person> filterListOfPersonByTeams(List<Person> listOfPerson, String team){
        ArrayList<Person>filteredPerson=new ArrayList<>();
        for (Person person:listOfPerson) {
            if (person.getParticipation().getListOfTeams().contains(team)){
                filteredPerson.add(person);
            }
        }
        return filteredPerson;
    }

    private List<Person> sortListOfPerson(List<Person> listOfPerson, String sortType){
        Collections.sort(listOfPerson);

        if (sortType.equals("asc")){
            return listOfPerson;
        }else if (sortType.equals("desc")){
            return listOfPerson;
        }
        return null;
    }


    private boolean isDepartmentAllowedToDelete(String departmentName){
        return departments.contains(departmentName);
    }

    private boolean isTeamAllowedToDelete(String team){
        boolean allowed=true;
        for (Person person:getAllPerson()) {
            if (person.getParticipation().getListOfTeams().contains(team)){
                allowed=false;
                break;
            }
        }
        return allowed;
    }

    private boolean isJobFunctionAllowedToDelete(String jobFunction){
        boolean allowed=true;
        for (Person person:getAllPerson()) {
            if (person.getParticipation().getListOfJobFunctions().contains(jobFunction)) {
                allowed = false;
                break;
            }
        }
        return allowed;
    }
}
