package ch.bzz.test;

import ch.bzz.dataHandler.DataHandler;
import ch.bzz.view.ListMaker;

import javax.swing.*;

public class ListMaker_Test {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        JFrame jFrame = new JFrame();


        ListMaker listMaker = new ListMaker(DataHandler.getInstance().getCompany().getJobFunctions().getListOfJobFunctions(), "Department");
        jFrame.add(listMaker);


        jFrame.pack();
        jFrame.setVisible(true);
    }
}
