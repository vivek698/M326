package ch.bzz.test;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Read_JSON_Test {
    static Company company;

    @Before
    public void init(){
        Write_JSON_Test_Data.run();
        DataHandler dataHandler=DataHandler.getInstance();
        company=dataHandler.getCompany();
    }

    @Test
    public void testListJobFunctions(){
        List<String> list=company.getJobFunctions().getListOfJobFunctions();

        String[] actuals = new String[list.size()];
        list.toArray(actuals);

        String[] expected={"Team Leader","Executive","Controller","Front-End developer","Back-End developer"};

        assertArrayEquals(expected,actuals);
    }

    @Test
    public void testListTeams(){
        List<String> list=company.getTeams().getListOfTeams();

        String[] actuals = new String[list.size()];
        list.toArray(actuals);

        String[] expected={"Team1","Team2","Team3","Team4"};

        assertArrayEquals(expected,actuals);
    }

    //TODO Check Company
    //TODO Check Departments
    //TODO Check Members
    //TODO Check Participations
}
