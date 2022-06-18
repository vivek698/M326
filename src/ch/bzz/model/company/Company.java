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
     * @param companyName
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
     * @param department replace Department
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
    public List<Department> getListofDepartment(){
        return departments;
    }

    /**
     * sets all departments
     *
     * @param departments list of departments
     */
    public void setListofDepartment(List<Department> departments){
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
     * @param teams
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
     * @param team
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
     * @param jobFunctions
     */
    public void setJobFunctions(JobFunctions jobFunctions){
        this.jobFunctions=jobFunctions;
    }

    /**
     * get jobFunction designation
     *
     * @param index of the designation
     * @return jobFunction desigantion
     */
    public String getJobFunction(int index) {
        return jobFunctions.getDesignation(index);
    }

    /**
     * sets a jobFunction
     *
     * @param index of a jobFunction
     * @param jobFunction
     */
    public void setJobFunctions(int index,String jobFunction) {
        jobFunctions.setDesignation(index,jobFunction);
    }

    /**
     * adds a new jobFunction
     *
     * @param function
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


    public List<Person> getAllPersonSort(String sortType){
        return sortListOfPerson(getAllPerson(),sortType);
    }



    public List<Person> getAllPersonFilteredByDepartment(String departmentName){
        return filterListOfPersonByDepartment(departmentName);
    }

    public List<Person> getAllPersonFilteredByFunktion(String funktion){
        return filterListOfPersonByFunction(getAllPerson(),funktion);
    }

    public List<Person> getAllPersonFilteredByTeams(String teams){
        return filterListOfPersonByTeams(getAllPerson(),teams);
    }

    public List<Person> getAllPersonFilteredByDepartmentAndFunction(String departmentName, String function){
        List<Person> filteredPerson= filterListOfPersonByDepartment(departmentName);
        filteredPerson= filterListOfPersonByFunction(filteredPerson,function);
        return filteredPerson;
    }

    public List<Person> getAllPersonFilteredByDepartmentAndTeams(String departmentName, String teams){
        List<Person> filteredPerson= filterListOfPersonByDepartment(departmentName);
        filteredPerson= filterListOfPersonByTeams(filteredPerson,teams);
        return filteredPerson;
    }

    public List<Person> getAllPersonFilteredByFunctionAndTeams(String function, String teams){
        List<Person> filteredPerson= filterListOfPersonByFunction(getAllPerson(),function);
        filteredPerson= filterListOfPersonByTeams(filteredPerson,teams);
        return filteredPerson;
    }

    public List<Person> getAllPersonFilteredByDepartmentAndFunctionAndTeams(String departmentName,String function,String teams){
        List<Person> filteredPerson= filterListOfPersonByDepartment(departmentName);
        filteredPerson= filterListOfPersonByTeams(filteredPerson,teams);
        filteredPerson= filterListOfPersonByTeams(filteredPerson,teams);
        return filteredPerson;
    }



    public List<Person> getAllPersonSortedFilteredByDepartment(String departmentName,String sortType){
        List<Person> filteredPerson = getAllPersonFilteredByDepartment(departmentName);
        sortListOfPerson(filteredPerson,sortType);
        return filteredPerson;
    }

    public List<Person> getAllPersonSortedFilteredByFunktion(String funktion,String sortType){
        List<Person> filteredPerson = getAllPersonFilteredByFunktion(funktion);
        sortListOfPerson(filteredPerson,sortType);
        return filteredPerson;
    }

    public List<Person> getAllPersonSortedFilteredByTeams(String teams,String sortType){
        List<Person> filteredPerson = getAllPersonFilteredByTeams(teams);
        sortListOfPerson(filteredPerson,sortType);
        return filteredPerson;
    }

    public List<Person> getAllPersonSortedFilteredByDepartmentAndFunction(String departmentName, String function,String sortType){
        List<Person> filteredPerson = getAllPersonFilteredByDepartmentAndFunction(departmentName,function);
        sortListOfPerson(filteredPerson,sortType);
        return filteredPerson;
    }

    public List<Person> getAllPersonSortedFilteredByDepartmentAndTeams(String departmentName, String teams,String sortType){
        List<Person> filteredPerson = getAllPersonFilteredByDepartmentAndTeams(departmentName,teams);
        sortListOfPerson(filteredPerson,sortType);
        return filteredPerson;
    }

    public List<Person> getAllPersonSortedFilteredByFunctionAndTeams(String function, String teams,String sortType){
        List<Person> filteredPerson = getAllPersonFilteredByFunctionAndTeams(function,teams);
        sortListOfPerson(filteredPerson,sortType);
        return filteredPerson;
    }

    public List<Person> getAllPersonSortedFilteredByDepartmentAndFunctionAndTeams(String departmentName,String function,String teams,String sortType){
        List<Person> filteredPerson = getAllPersonFilteredByDepartmentAndFunctionAndTeams(departmentName,function,teams);
        sortListOfPerson(filteredPerson,sortType);
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
            if (person.getParticipation().getListOfTeams().contains(jobFunction)){
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

}
