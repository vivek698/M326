package ch.bzz.test;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import ch.bzz.model.company.Department;
import ch.bzz.model.employees.HRPerson;
import ch.bzz.model.employees.Participation;
import ch.bzz.model.employees.Person;

public class Write_JSON_Test {
    public static void main(String[] args) {
       run();
    }
    public static void run(){
        Company company = new Company("NukufelGMBH");
        setCompanyDepartments(company);
        setCompanyTeams(company);
        setCompanyJobFunction(company);

        DataHandler dataHandler=DataHandler.getInstance();
        dataHandler.setCompany(company);
    }

    public static void setCompanyDepartments(Company company){
        Department department1=new Department("IT-Abteilung");
        Department department2=new Department("Verwaltungs Abteilung");

        setDepartmentPerson(department1);
        setDepartmentPerson(department2);

        company.addDepartment(department1);
        company.addDepartment(department2);
    }
    public static void setDepartmentPerson(Department department){
        Person person1=new Person("Max","Mustermann");
        HRPerson person2=new HRPerson("Lorenzo","Lorenzo",1);

        setPersonParticipation(person1);
        setPersonParticipation(person2);
        person2.setPwd("passwort1");

        department.addMember(person1);
        department.addMember(person2);
    }
    public static void setPersonParticipation(Person person){
        Participation participation=new Participation();

        participation.addFunction("IT-Abteilung");
        participation.addFunction("Verwaltungs Abteilung");

        participation.addTeams("Team1");
        participation.addTeams("Team2");

        person.setParticipation(participation);
    }

    public static void setCompanyTeams(Company company){
        company.addTeams("Team1");
        company.addTeams("Team2");
        company.addTeams("Team3");
        company.addTeams("Team4");
    }

    public static void setCompanyJobFunction(Company company){
        company.addJobFunction("Geschäftsleitung");
        company.addJobFunction("HR-Person");
    }
}
