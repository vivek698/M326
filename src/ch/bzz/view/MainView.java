package ch.bzz.view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (tabbedPane.getSelectedIndex()==1||tabbedPane.getSelectedIndex()==2){
                    new Login(1);
                }else if (tabbedPane.getSelectedIndex()==3||tabbedPane.getSelectedIndex()==4){
                    new Login(2);
                }
            }
        });



        pack();
        setSize(700,700);

        setVisible(true);


    }

    public static void main(String[] args) {
        new MainView();
    }
}
