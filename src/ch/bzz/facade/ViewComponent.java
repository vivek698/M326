package ch.bzz.facade;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.exception.NotExistingDepartmentException;
import ch.bzz.model.company.Company;
import ch.bzz.model.company.Department;
import ch.bzz.model.employees.HRPerson;
import ch.bzz.model.employees.Person;
import ch.bzz.view.LogBookView;
import ch.bzz.view.TestListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade
 * @author Niklas Vogel (Nukufel)
 * @since 22.06.2022
 * @version 1.4
 */
public class ViewComponent {
    private List<TestListModel> models = new ArrayList<>();
    private static ViewComponent instance = null;
    private Company companyInstance;
    private LogBookView logBookView = null;

    /**
     * Constructor
     */
    private ViewComponent(){
        companyInstance = DataHandler.getInstance().getCompany();
    }


    /**
     * gets an instance of ViewComponent
     * @return ViewComponent
     */
    public static ViewComponent getInstance(){
        if(instance == null){
            instance = new ViewComponent();
        }
        return instance;
    }

    /**
     * adds a department
     * @param name String name of department
     */
    public void addDepartment(String name){
        companyInstance.addDepartment(new Department(name));
        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

    /**
     * adds a jobFunction
     * @param name String name of jobFunction
     */
    public void addJobFunction(String name){
        companyInstance.addJobFunction(name);
        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

    /**
     * adds a team
     * @param name String name of team
     */
    public void addTeam(String name){
        companyInstance.addTeams(name);
        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

    /**
     * adds/creates a Person in a department
     * @param departmentName String name of department
     * @param person Person Object
     * @throws NotExistingDepartmentException
     */
    public void addPerson(String departmentName, Person person) throws NotExistingDepartmentException {
        companyInstance.getDepartmentByName(departmentName).addMember(person);
        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

    /**
     * changes name, department and img of a person
     * @param firstName String
     * @param lastName String
     * @param newFirstName String
     * @param newLastName String
     * @param departmentName String
     * @param path String
     * @throws NotExistingDepartmentException
     */
    public void correctParson(String firstName, String lastName, String newFirstName, String newLastName, String departmentName, String path) throws NotExistingDepartmentException {
        Person person = companyInstance.getPerson(companyInstance.getDepartmentIndexByPerson(firstName, lastName),companyInstance.getPersonIndexByName(firstName, lastName));

        companyInstance.getDepartment(companyInstance.getDepartmentIndexByPerson(firstName, lastName)).removeMember(companyInstance.getPersonIndexByName(firstName, lastName));
        companyInstance.getDepartmentByName(departmentName).addMember(person);


        person.setFirstName(newFirstName);
        person.setLastName(newLastName);
        person.setImage(path);




        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

    /**
     * corrects a department
     * @param name String
     * @param index int
     */
    public void correctDepartment(String name, int index){
        companyInstance.getDepartment(index).setName(name);
        changer();
    }

    /**
     * corrects a JobFunktion
     * @param index int
     * @param name String
     */
    public void correctJobFunction( int index, String name){
        companyInstance.setJobFunction(index,name);
        changer();
    }

    /**
     * corrects a Team
     * @param index int
     * @param name String
     */
    public void correctTeam(int index, String name){
        companyInstance.setTeam(index, name);
        changer();
    }

    /**
     * deletes a department
     * @param index int
     */
    public void deleteDepartment(int index){
        companyInstance.removeDepartment(index);
        changer();
    }

    /**
     * deletes a jobFunction
     * @param index int
     */
    public void deleteJobFunction(int index){
        companyInstance.removeJobFunction(index);
        changer();
    }

    /**
     * deletes a Team
     * @param index int
     */
    public void  deleteTeam(int index){
        companyInstance.removeTeam(index);
        changer();
    }

    /**
     * delets a person out of a department
     * @param firstname String
     * @param lastName String
     */
    public void deletePerson(String firstname, String lastName){
        companyInstance.getDepartment(companyInstance.getDepartmentIndexByPerson(firstname, lastName)).removeMember(companyInstance.getPersonIndexByName(firstname, lastName));
        changer();
    }

    /**
     * adds a model for the list
     * @param tml ListModel objekt
     */
    public void addModel(TestListModel tml){
        models.add(tml);
    }

    /**
     * deletes a model for the list
     * @param tml ListModel objekt
     */
    public void removeModel(TestListModel tml){
        models.remove(tml);
    }

    /**
     * updates the List if sth. changes
     */
    public void changer(){
        for (TestListModel tml: models){
            tml.fireContentsChanged(this,0,-1);
        }
        DataHandler.getInstance().setCompany(companyInstance);
    }

    /**
     * gets List of departments
     * @return List of departments
     */
    public List<Department> getDepartmentList(){
        return companyInstance.getListOfDepartment();
    }

    /**
     * gets List of jobFunctions
     * @return List of jobFunctions
     */
    public List<String> getJobFunctionList(){
        return companyInstance.getJobFunctions().getListOfJobFunctions();
    }

    /**
     * gets List of teams
     * @return List of teams
     */
    public  List<String> getTeamList(){
        return companyInstance.getTeams().getListOfTeams();
    }

    /**
     * get all persons
     * @return List of Person
     */
    public List<Person> getAllPersonOfCompany(){
        return companyInstance.getAllPerson();
    }

    /**
     * gets a Picture
     * @param index1 int department index
     * @param index2 int person index
     * @return String img path
     */
    public String getPicture(int index1, int index2){
        return companyInstance.getPerson(index1,index2).getImgPath();
    }

    /**
     * gets all HR-Persons
     * @return  List of HR-person
     */
    public List<HRPerson> getAllHRPerson(){
        return companyInstance.getListOfHRPerson();
    }

    /**
     * get all admins
     * @return List of HRPerosn (admins)
     */
    public List<HRPerson> getAllHRPersonMode1(){
        return companyInstance.getListOfHRPersonMode1();
    }

    /**
     * maks a person to HRPerson
     * @param fullName String
     * @param mode int
     */
    public void convertToHRPerson(String fullName, int mode){
        String[] name= fullName.split(" ");

        int indexDepartment = companyInstance.getDepartmentIndexByPerson(name[0],name[1]);
        int indexPerson = companyInstance.getDepartment(indexDepartment).getMemberIndexByFullname(fullName);
        companyInstance.setConvertToHRPerson(indexDepartment,indexPerson,mode);
    }

    /**
     * HrPerson to person
     * @param fullName String
     */
    public void convertToPerson(String fullName){
        String[] name= fullName.split(" ");

        int indexDepartment = companyInstance.getDepartmentIndexByPerson(name[0],name[1]);
        int indexPerson = companyInstance.getDepartment(indexDepartment).getMemberIndexByFullname(fullName);
        companyInstance.setConvertToPerson(indexDepartment,indexPerson);
    }

    /**
     * sets Passwort for HR person
     * @param person HRPerson object
     * @param password String
     */
    public void setPasswordPerson(HRPerson person,String password){
        person.setPassword(password);
    }


    /**
     * gets a person by its full name
     * @param fullName String
     * @return Person object
     */
    public Person getPersonByFullName(String fullName){
        return companyInstance.getPersonByName(fullName);
    }





}
