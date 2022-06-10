package ch.bzz.dataHandler;

import ch.bzz.model.company.Company;
import ch.bzz.model.company.Department;
import ch.bzz.model.company.JobFunctions;
import ch.bzz.model.company.Teams;



import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataHandler {
    private static DataHandler dataHandler;
    private Company company;

    private DataHandler() {
    }

    public static DataHandler getInstance(){
        if (dataHandler==null){
            dataHandler=new DataHandler();
        }
        return dataHandler;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * reads the company from the JSON-file
     */
    public void readCompanyJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get("Company.json")
            );
            ObjectMapper objectMapper = new ObjectMapper();
            company = objectMapper.readValue(jsonData,Company.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * writes the company to the JSON-file
     */
    public void writeCompanyJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream;
        Writer fileWriter;

        String companyPath = "Company.json";
        try {
            fileOutputStream = new FileOutputStream(companyPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getCompany());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
