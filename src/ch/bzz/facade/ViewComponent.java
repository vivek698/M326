package ch.bzz.facade;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import ch.bzz.model.company.Department;
import ch.bzz.model.employees.Person;
import ch.bzz.view.TestListModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ViewComponent {
    private List<TestListModel> models = new ArrayList<>();
    private static ViewComponent instance = null;
    private Company companyInstance;
    private ViewComponent(){
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

    public void addPerson(String departmentName, String fullname){
        //companyInstance.getDepartment(companyInstance.getDepartmentbyName(departmentName)).addMember();
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

    public void deleteDepartment(int index){
        companyInstance.removeDepartment(index);
        changer();
    }

    public void deleteJobFunction(int index){
        companyInstance.removeJobFunction(index);
        changer();
    }

    public void deleteTeam(int index){
        companyInstance.removeTeam(index);
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

    /**
     * get Image as ImageIcon
     *
     * @return image
     */
    private ImageIcon getImage(Person person){
        ImageIcon houseIcon = new ImageIcon(
                Objects.requireNonNull(
                        this.getClass()
                                .getResource(person.getImgPath())));

        return new ImageIcon(String.valueOf(houseIcon));
    }


}
