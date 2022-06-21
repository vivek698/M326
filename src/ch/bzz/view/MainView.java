package ch.bzz.view;

import javax.swing.*;

public class MainView extends JFrame {
    private JTabbedPane tabbedPane = new JTabbedPane();


    public MainView(){
        setTitle("MainGUI");

        tabbedPane.add("Übersicht", new UebersichtView());
        tabbedPane.add("Zuordnen", new ZuordenenView());
        tabbedPane.add("Personen", new PersonView());
        tabbedPane.addTab("Stammdaten", new Stammdaten());
        tabbedPane.addTab("Logbuch", new LogBookView());


        add(tabbedPane);

        pack();
        setSize(700,700);

        setVisible(true);


    }

    public static void main(String[] args) {
        new MainView();
    }
}
