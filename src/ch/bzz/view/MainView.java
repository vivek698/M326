package ch.bzz.view;

import javax.swing.*;

public class MainView extends JFrame {
    private JTabbedPane tabbedPane = new JTabbedPane();

    public MainView(){
        setTitle("MainGUI");

        tabbedPane.addTab("Stammdaten", new Stammdaten());

        add(tabbedPane);

        pack();
        setSize(700,700);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
