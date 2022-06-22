package ch.bzz.view;


import ch.bzz.facade.ViewComponent;

import javax.swing.*;
import java.util.List;

/**
 * List model for ListMaker
 *
 * @author Niklas Vogel (Nukufel), Vivek Viruthiyel
 * @since 22.06.2022
 * @version 1
 */
public class TestListModel extends AbstractListModel<String> {
    private String art;

    /**
     * Creates TestListModel
     * @param art usage type
     */
    public TestListModel(String art) {
        ViewComponent.getInstance().addModel(this);
        this.art = art;
    }

    @Override
    public int getSize() {
        switch (art) {
            case "Department":
                return ViewComponent.getInstance().getDepartmentList().size();
            case "JobFunction":
                return ViewComponent.getInstance().getJobFunctionList().size();
            case "Team":
                return ViewComponent.getInstance().getTeamList().size();
            case "PersonView":
                return ViewComponent.getInstance().getAllPersonOfCompany().size();
        }
        return 0;
    }

    /**
     * gets Element by index
     * @param index of Element
     * @return Element
     */
    @Override
    public String getElementAt(int index) {
        switch (art) {
            case "Department":
                return ViewComponent.getInstance().getDepartmentList().get(index).getName();
            case "JobFunction":
                return ViewComponent.getInstance().getJobFunctionList().get(index);
            case "Team":
                return ViewComponent.getInstance().getTeamList().get(index);
            case "PersonView":
                return ViewComponent.getInstance().getAllPersonOfCompany().get(index).getFullName();
        }
        return null;
    }

    /**
     * sends message, that something has changed
     * @param source
     * @param index0
     * @param index1
     */
    @Override
    public void fireContentsChanged(Object source, int index0, int index1) {
        if (index1 == -1) {
            super.fireContentsChanged(source, index0, getSize());
        } else {
            super.fireContentsChanged(source, index0, index1);
        }
    }
    }
