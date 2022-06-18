package ch.bzz.test;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import ch.bzz.model.company.Department;
import ch.bzz.model.employees.HRPerson;
import ch.bzz.model.employees.Participation;
import ch.bzz.model.employees.Person;

public class Write_JSON_Test_Data {
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
        Department department1=new Department("General Management");
        Department department2=new Department("IT");


        setDepartment1Person(department1);
        setDepartment2Person(department2);

        company.addDepartment(department1);
        company.addDepartment(department2);
    }

    public static void setDepartment1Person(Department department){
        HRPerson person1=new HRPerson("Lorenzo","Giuntini",1);
        Person person2=new Person("Max","Mustermann");

        setD1Person1Participation(person1);
        setD1Person2Participation(person2);
        person1.setPwd("passwort1");

        department.addMember(person1);
        department.addMember(person2);
    }
    public static void setD1Person1Participation(Person person){
        Participation participation=new Participation();

        participation.addFunction("Team Leader");

        participation.addTeams("Team1");

        person.setParticipation(participation);
    }
    public static void setD1Person2Participation(Person person){
        Participation participation=new Participation();

        participation.addFunction("Executive");
        participation.addFunction("Controller");

        participation.addTeams("Team3");
        participation.addTeams("Team4");

        person.setParticipation(participation);
    }

    public static void setDepartment2Person(Department department){
        Person person1=new Person("Mikaela","Hinton");
        Person person2=new Person("Genesis","Patrick");

        setD2Person1Participation(person1);
        setD2Person2Participation(person2);

        department.addMember(person1);
        department.addMember(person2);
    }
    public static void setD2Person1Participation(Person person){
        Participation participation=new Participation();

        participation.addFunction("Team Leader");
        participation.addFunction("Front-End developer");

        participation.addTeams("Team1");

        person.setParticipation(participation);
    }
    public static void setD2Person2Participation(Person person){
        Participation participation=new Participation();

        participation.addFunction("Back-End developer");

        participation.addTeams("Team1");
        participation.addTeams("Team4");

        person.setParticipation(participation);
    }

    public static void setCompanyTeams(Company company){
        company.addTeams("Team1");
        company.addTeams("Team2");
        company.addTeams("Team3");
        company.addTeams("Team4");
    }

    public static void setCompanyJobFunction(Company company){
        company.addJobFunction("Team Leader");
        company.addJobFunction("Executive");
        company.addJobFunction("Controller");
        company.addJobFunction("Front-End developer");
        company.addJobFunction("Back-End developer");
    }
}
