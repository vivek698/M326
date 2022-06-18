package ch.bzz.dataHandler;

import ch.bzz.model.company.Company;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Get and Converts the Data from the JSON-Files
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 */
public class DataHandler {
    private static DataHandler dataHandler;
    private Company company;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
    }

    /**
     * gets the only instance of this class
     *
     * @return instance of DataHandler
     */
    public static DataHandler getInstance(){
        if (dataHandler==null){
            dataHandler=new DataHandler();
        }
        return dataHandler;
    }

    /**
     * gets Company from JSON-File
     *
     * @return company
     */
    public Company getCompany() {
        readCompanyJSON();
        return company;
    }

    /**
     * sets company and writes the JSON-FIle new
     *
     * @param company
     */
    public void setCompany(Company company) {
        this.company = company;
        writeCompanyJSON();
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
            objectWriter.writeValue(fileWriter, company);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
