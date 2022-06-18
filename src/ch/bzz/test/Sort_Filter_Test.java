package ch.bzz.test;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import ch.bzz.model.employees.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void getAllMembers(){
        List<Person> allPerson=company.getAllPerson();
        String[] actuals = new String[allPerson.size()];

        for (int i = 0; i < allPerson.size(); i++) {
            actuals[i]=allPerson.get(i).getFullName();
        }

        String[]expected={"Lorenzo Giuntini","Max Mustermann","Mikaela Hinton","Genesis Patrick"};

        assertArrayEquals(expected,actuals);

    }

}
