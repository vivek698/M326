package ch.bzz.test;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import ch.bzz.model.employees.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Sort_Filter_Test {
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
    public void getAllPersonSort(){
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,null,null,"asc"));

        String[]expected={"Genesis Patrick","Lorenzo Giuntini","Max Mustermann","Mikaela Hinton"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByDepartment(){
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted("General Management",null,null,null));

        String[]expected={"Lorenzo Giuntini","Max Mustermann"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByFunction(){
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,"Team Leader",null,null));

        String[]expected={"Lorenzo Giuntini","Mikaela Hinton"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByTeam(){
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,null,"Team4",null));

        String[]expected={"Max Mustermann","Genesis Patrick"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByTwo(){
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,"Team Leader","Team1",null));

        String[]expected={"Lorenzo Giuntini"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredAndSorted(){
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted(null,null,"Team1","asc"));

        String[]expected={"Genesis Patrick","Lorenzo Giuntini"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void getAllPersonFilteredByThree(){
        String[] actuals =arrayToList(company.getPersonFilteredAndSorted("General Management","Team Leader","Team1",null));

        String[]expected={"Lorenzo Giuntini"};

        assertArrayEquals(expected,actuals);
    }

}
