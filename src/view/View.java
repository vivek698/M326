package view;

import javax.swing.*;
import java.awt.event.*;

/**
 * M326 View Version 0.1
 * Jonas Rhbary
 */
class View implements ActionListener{
    JFrame f;
    JFrame uebersichtFrame;
    JFrame zuordnungFrame;
    JFrame personenFrame;
    JFrame stammdatenFrame;
    JFrame logbuchFrame;

    JTextField test;

    JMenuBar mb;
    JMenu uebersicht,zuordnung,personen,stammdaten,logbuch;
    View(){
        f=new JFrame();
        mb=new JMenuBar();
        uebersicht=new JMenu("Übersicht");
        zuordnung=new JMenu("Zuordnung");
        personen=new JMenu("Personen");
        stammdaten=new JMenu("Stammdaten");
        logbuch=new JMenu("Logbuch");

        uebersicht.addActionListener(this);
        zuordnung.addActionListener(this);
        personen.addActionListener(this);
        stammdaten.addActionListener(this);
        logbuch.addActionListener(this);


        mb.add(uebersicht);mb.add(zuordnung);mb.add(personen);mb.add(stammdaten);mb.add(logbuch);
        f.add(mb);
        f.setJMenuBar(mb);
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == uebersicht)
            uebersichtFrame = new JFrame();
                uebersichtFrame.add(mb);
                uebersichtFrame.setJMenuBar(mb);
                uebersichtFrame.setLayout(null);
                uebersichtFrame.setSize(400,400);
                uebersichtFrame.setVisible(true);
                uebersichtFrame.add(test);

        if(e.getSource() == zuordnung)
            zuordnungFrame = new JFrame();
        if(e.getSource() == personen)
            personenFrame = new JFrame();
        if(e.getSource() == stammdaten)
            stammdatenFrame = new JFrame();
        if(e.getSource() == logbuch)
            logbuchFrame = new JFrame();

    }
    public static void main(String[] args) {
        new View();
    }
}