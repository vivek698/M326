package view;

import javax.swing.*;
import java.awt.event.*;

/**
 * M326 View Version 0.1
 * Jonas Rhbary
 */
class View implements ActionListener{
    JFrame f;
    JFrame overviewFrame;
    JFrame assignmentFrame;
    JFrame personsFrame;
    JFrame basedatanFrame;
    JFrame logFrame;

    JTextField test;

    JMenuBar mb;
    JMenu overview,assignment,persons,basedata,log;
    View(){
        f=new JFrame();

        mb=new JMenuBar();
        overview=new JMenu("Overview");
        assignment=new JMenu("Assignment");
        persons=new JMenu("Persons");
        basedata=new JMenu("Base Data");
        log=new JMenu("Log");



        overview.addActionListener(this);
        assignment.addActionListener(this);
        persons.addActionListener(this);
        basedata.addActionListener(this);
        log.addActionListener(this);


        mb.add(overview);mb.add(assignment);mb.add(persons);mb.add(basedata);mb.add(log);
        f.add(mb);
        f.setJMenuBar(mb);
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);

        overviewFrame = new JFrame();


    }
    public void actionPerformed(ActionEvent e) {
        if(overview.isSelected())
            overviewFrame.setVisible(true);
        if(e.getSource() == assignment)
            assignmentFrame = new JFrame();
        if(e.getSource() == persons)
            personsFrame = new JFrame();
        if(e.getSource() == basedata)
            basedatanFrame = new JFrame();
        if(e.getSource() == log)
            logFrame = new JFrame();

    }
    public static void main(String[] args) {
        new View();
    }
}