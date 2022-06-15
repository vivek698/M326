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
        Write_JSON_Test.main(new String[0]);
        DataHandler dataHandler=DataHandler.getInstance();
        company=dataHandler.getCompany();
    }

    @Test
    public void testListJobFunctions(){
        List<String> list=company.getJobFunctions().getListOfJobFunctions();

        String[] actuals = new String[list.size()];
        list.toArray(actuals);

        String[] expected={"Geschäftsleitung", "HR-Person"};

        assertArrayEquals(expected,actuals);
    }
}
