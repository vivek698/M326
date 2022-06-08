package ch.bzz.view;

import javax.swing.*;
import java.awt.event.*;

/**
 * M326 View Version 0.1
 * Jonas Rhbary
 */
class View implements ActionListener{
    JFrame f;
    JMenuBar mb;
    JMenu uebersicht,zuordnung,personen,stammdaten,logbuch;
    View(){
        f=new JFrame();
        mb=new JMenuBar();
        uebersicht=new JMenu("Übersicht");
        zuordnung=new JMenu("Zurodnung");
        personen=new JMenu("Personen");
        stammdaten=new JMenu("Stammdaten");
        logbuch=new JMenu("Logbuch");

        mb.add(uebersicht);mb.add(zuordnung);mb.add(personen);mb.add(stammdaten);mb.add(logbuch);
        f.add(mb);
        f.setJMenuBar(mb);
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
    }
    public static void main(String[] args) {
        new View();
    }
}