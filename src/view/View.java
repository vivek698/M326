package view;

import javax.swing.*;
import java.awt.event.*;

/**
 * M326 View Version 0.1
 * Jonas Rhbary
 */
class View implements ActionListener{
    JFrame f;
    JTabbedPane tabbedPane;
    private LogBookView logBookView;

    JMenuItem test;

    View(){
        f=new JFrame("Welcome");

        tabbedPane = new JTabbedPane();
        tabbedPane.add("LogBook", logBookView);


        f.add(tabbedPane);
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);



    }

    /**
    public void actionPerformed(ActionEvent e) {
        if(overview.isSelected())
            overviewFrame.setVisible(true);
        if(e.getSource() == assignment)
            assignmentFrame = new JFrame();
        if(e.getSource() == persons)
            personsFrame = new JFrame();
        if(e.getSource() == basedata)
            basedataFrame = new JFrame();
        if(log.isMenuComponent(log)) {
            final LogBookView logBookView = new LogBookView();
        };

    }*/
    public static void main(String[] args) {
        new View();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}