package ch.bzz.view;



import ch.bzz.facade.ViewComponent;

import javax.swing.*;
import java.util.List;

public class TestListModel extends AbstractListModel<String> {
    private String art;

    public TestListModel(String art){
        ViewComponent.getInstance().addModel(this);
        this.art = art;
    }

    @Override
    public int getSize() {
       switch (art){
           case "Department":
               return ViewComponent.getInstance().getDepartmentList().size();
           case "JobFunction":
               return ViewComponent.getInstance().getJobFunctionList().size();
           case "Team":
               return ViewComponent.getInstance().getTeamList().size();
           case "Person":
               return ViewComponent.getInstance().getAllPersonOfCompany().size();


       }
       return 0;
    }

    @Override
    public String getElementAt(int index) {
        switch (art){
            case "Department":
                return ViewComponent.getInstance().getDepartmentList().get(index).getName();
            case "JobFunction":
                return ViewComponent.getInstance().getJobFunctionList().get(index);
            case "Team":
                return ViewComponent.getInstance().getTeamList().get(index);
            case "Person":
                return ViewComponent.getInstance().getAllPersonOfCompany().get(index).getFullName();
        }
        return null;
    }

    @Override
    public void fireContentsChanged(Object source, int index0, int index1){
        if (index1 == -1){
            super.fireContentsChanged(source, index0, getSize());
        }else {
            super.fireContentsChanged(source, index0, index1);
        }
    }







}
