package ch.bzz.view;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.model.company.Company;
import ch.bzz.model.company.Department;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

public class TestListModel extends AbstractListModel<String> {
    private List<String> values;

    public TestListModel(List<String> values) {
        this.values=values;
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public String getElementAt(int index) {
        return values.get(index);
    }


}
