package ch.bzz.view;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import ch.bzz.model.company.Department;

import javax.swing.*;
import javax.swing.event.ListDataListener;

public class TestListModel extends AbstractListModel<String> {
    private String stammdaten;

    public TestListModel() {
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String getElementAt(int index) {
        switch (stammdaten) {
            case "Abteilungen": {
                Company company = DataHandler.getInstance().getCompany();
                //return company.getDepartment(index).getName();
                return "apfel";
            }
        }
        return null;
    }

    public String setElementAt(){
        return null;
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
