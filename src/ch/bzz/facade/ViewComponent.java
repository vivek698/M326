package ch.bzz.facade;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.exception.NotExistingDepartmentException;
import ch.bzz.model.company.Company;
import ch.bzz.model.company.Department;
import ch.bzz.model.employees.Person;
import ch.bzz.view.LogBookView;
import ch.bzz.view.TestListModel;

import java.util.ArrayList;
import java.util.List;

public class ViewComponent {
    private List<TestListModel> models = new ArrayList<>();
    private static ViewComponent instance = null;
    private Company companyInstance;
    private LogBookView logBookView = null;
    public ViewComponent(){
        companyInstance = DataHandler.getInstance().getCompany();
    }


    public static ViewComponent getInstance(){
        if(instance == null){
            instance = new ViewComponent();
        }
        return instance;
    }

    public void addDepartment(String name){
        companyInstance.addDepartment(new Department(name));
        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

    public void addJobFunction(String name){
        companyInstance.addJobFunction(name);
        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

    public void addTeam(String name){
        companyInstance.addTeams(name);
        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

    public void addPerson(String departmentName, Person person) throws NotExistingDepartmentException {
        companyInstance.getDepartmentByName(departmentName).addMember(person);
        DataHandler.getInstance().setCompany(companyInstance);
        changer();
    }

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

    public void correctDepartment(String name, int index){
        companyInstance.getDepartment(index).setName(name);
        changer();
    }

    public void correctJobFunction( int index, String name){
        companyInstance.setJobFunction(index,name);
        changer();
    }

    public void correctTeam(int index, String name){
        companyInstance.setTeam(index, name);
        changer();
    }

    //TODO
    public void correctJobFunctionForZuordnung( int index, String name){
        companyInstance.setJobFunction(index, name);
        changer();
    }

    //TODO
    public void correctTeamForZuordnung( int index, String name){
        companyInstance.setJobFunction(index, name);
        changer();
    }

    public void deleteDepartment(int index){
        companyInstance.removeDepartment(index);
        changer();
    }

    public void deleteJobFunction(int index){
        companyInstance.removeJobFunction(index);
        changer();
    }

    public void  deleteTeam(int index){
        companyInstance.removeTeam(index);
        changer();
    }

    public void deletePerson(String firstname, String lastName){
        companyInstance.getDepartment(companyInstance.getDepartmentIndexByPerson(firstname, lastName)).removeMember(companyInstance.getPersonIndexByName(firstname, lastName));
        changer();
    }

    //TODO
    public void deleteJobFunctionForZuordnung(int index){
        companyInstance.removeJobFunction(index);
        changer();
    }

    //TODO
    public void deleteTeamForZuordnung(int index){
        companyInstance.removeJobFunction(index);
        changer();
    }

    public void addModel(TestListModel tml){
        models.add(tml);
    }

    public void removeModel(TestListModel tml){
        models.remove(tml);
    }

    public void changer(){
        for (TestListModel tml: models){
            tml.fireContentsChanged(this,0,-1);
        }
        DataHandler.getInstance().setCompany(companyInstance);
    }

    public List<Department> getDepartmentList(){
        return companyInstance.getListOfDepartment();
    }

    public List<String> getJobFunctionList(){
        return companyInstance.getJobFunctions().getListOfJobFunctions();
    }

    public  List<String> getTeamList(){
        return companyInstance.getTeams().getListOfTeams();
    }

    public List<Person> getAllPersonOfCompany(){
        return companyInstance.getAllPerson();
    }

    public String getPicture(int index1, int index2){
        return companyInstance.getPerson(index1,index2).getImgPath();
    }











}
