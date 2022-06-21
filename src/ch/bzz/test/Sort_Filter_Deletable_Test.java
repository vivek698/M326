package ch.bzz.test;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import ch.bzz.model.employees.Person;
import ch.bzz.exception.NotExistingDepartmentException;
import ch.bzz.exception.NotExistingJobFunctionException;
import ch.bzz.exception.NotExistingTeamException;
import ch.bzz.exception.SortTypeException;
import org.junit.Before;
import org.junit.Test;


import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Sort_Filter_Deletable_Test {
    static Company company;

    @Before
    public void init(){
        Write_JSON_Test_Data.run();
        DataHandler dataHandler=DataHandler.getInstance();
        company=dataHandler.getCompany();
    }


    private static String[] arrayToList(List<Person> list){
        String[] array = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i]=list.get(i).getFullName();
        }
        return array;
    }


    @Test
    public void getAllPerson(){
        String[] actuals =arrayToList(company.getAllPerson());

        String[]expected={"Lorenzo Giuntini","Max Mustermann","Mikaela Hinton","Genesis Patrick"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonSortASC() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,null,null,"asc", null));

        String[]expected={"Genesis Patrick","Lorenzo Giuntini","Max Mustermann","Mikaela Hinton"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonSortDESC() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,null,null,"desc", null));

        String[]expected={"Mikaela Hinton","Max Mustermann","Lorenzo Giuntini","Genesis Patrick"};

        assertArrayEquals(expected,actuals);
    }

    @Test (expected = SortTypeException.class)
    public void getAllPersonSortException() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        company.getPersonFilteredAndSorted(null,null,null,"falsch", null);
    }



    @Test
    public void getAllPersonFilteredByDepartment() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted("General Management",null,null,null, null));

        String[]expected={"Lorenzo Giuntini","Max Mustermann"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByFunction() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,"Team Leader",null,null, null));

        String[]expected={"Lorenzo Giuntini","Mikaela Hinton"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByTeam() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,null,"Team4",null, null));

        String[]expected={"Max Mustermann","Genesis Patrick"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getPersonSearch() throws NotExistingJobFunctionException, SortTypeException, NotExistingDepartmentException, NotExistingTeamException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,null,null,null, "Max"));

        String[]expected={"Max Mustermann"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByTwo() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,"Team Leader","Team1",null, null));

        String[]expected={"Lorenzo Giuntini"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredAndSorted() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,null,"Team1","asc", null));

        String[]expected={"Genesis Patrick","Lorenzo Giuntini"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByThree() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted("General Management","Team Leader","Team1",null, null));

        String[]expected={"Lorenzo Giuntini"};

        assertArrayEquals(expected,actuals);
    }




    @Test (expected = NotExistingDepartmentException.class)
    public void getAllPersonFilteredByDepartmentException() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        company.getPersonFilteredAndSorted("falsch",null,null,null, null);
    }

    @Test (expected = NotExistingJobFunctionException.class)
    public void getAllPersonFilteredByJobFunctionException() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        company.getPersonFilteredAndSorted(null,"falsch",null,null, null);
    }

    @Test (expected = NotExistingTeamException.class)
    public void getAllPersonFilteredByTeamException() throws NotExistingDepartmentException, NotExistingJobFunctionException,NotExistingTeamException, SortTypeException {
        company.getPersonFilteredAndSorted(null,null,"falsch",null, null);
    }




    @Test
    public void isDepartmentDeletableTrue() throws NotExistingDepartmentException {
        boolean actuals =company.isDepartmentDeletable("Finance");

        boolean expected=true;

        assertEquals(expected,actuals);
    }

    @Test
    public void isJobFunctionDeletableTrue() throws NotExistingJobFunctionException {
        boolean actuals =company.isJobFunctionDeletable("Fullstack developer");

        boolean expected=true;

        assertEquals(expected,actuals);
    }

    @Test
    public void isTeamDeletableTrue() throws NotExistingTeamException {
        boolean actuals =company.isTeamDeletable("Team5");

        boolean expected=true;

        assertEquals(expected,actuals);
    }



    @Test
    public void isDepartmentDeletableFalse() throws NotExistingDepartmentException {
        boolean actuals =company.isDepartmentDeletable("General Management");

        boolean expected=false;

        assertEquals(expected,actuals);
    }

    @Test
    public void isJobFunctionDeletableFalse() throws NotExistingJobFunctionException {
        boolean actuals =company.isJobFunctionDeletable("Team Leader");

        boolean expected=false;

        assertEquals(expected,actuals);
    }

    @Test
    public void isTeamDeletableFalse() throws NotExistingTeamException {
        boolean actuals =company.isTeamDeletable("Team1");

        boolean expected=false;

        assertEquals(expected,actuals);
    }



    @Test (expected = NotExistingDepartmentException.class)
    public void isDepartmentDeletablException() throws NotExistingDepartmentException {
        company.isDepartmentDeletable("Exception");
    }

    @Test (expected = NotExistingJobFunctionException.class)
    public void isJobFunctionDeletablException() throws NotExistingJobFunctionException {
        company.isJobFunctionDeletable("Exception");
    }

    @Test (expected = NotExistingTeamException.class)
    public void isTeamDeletablException() throws NotExistingTeamException {
        company.isTeamDeletable("Exception");
    }

    @Test
    public void departmentExistTrue(){
        boolean actual=company.departmentExist("General Management");
        boolean expected =true;
        assertEquals(expected,actual);
    }

    @Test
    public void jobFunctionExistTrue(){
        boolean actual=company.jobFunctionExist("Team Leader");
        boolean expected =true;
        assertEquals(expected,actual);
    }

    @Test
    public void teamExistTrue(){
        boolean actual=company.teamExist("Team1");
        boolean expected =true;
        assertEquals(expected,actual);
    }


    @Test
    public void departmentExistFalse(){
        boolean actual=company.departmentExist("wrong");
        boolean expected =false;
        assertEquals(expected,actual);
    }

    @Test
    public void jobFunctionExistFalse(){
        boolean actual=company.departmentExist("wrong");
        boolean expected =false;
        assertEquals(expected,actual);
    }

    @Test
    public void teamExistFalse(){
        boolean actual=company.teamExist("wrong");
        boolean expected =false;
        assertEquals(expected,actual);
    }
}
