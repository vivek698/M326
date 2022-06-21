package ch.bzz.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static java.awt.BorderLayout.*;

public class Stammdaten extends JPanel {

    private JPanel labelPanel = new JPanel(new BorderLayout());
    private JPanel textFieldPanel = new JPanel(new BorderLayout());
    private JPanel abteilungPanel = new JPanel(new BorderLayout());
    private JPanel funktionPanel = new JPanel(new BorderLayout());
    private JPanel teamPanel = new JPanel(new BorderLayout());


    private JLabel firma = new JLabel("Frima:                            ");
    private JTextField textField = new JTextField("NukufelGMBH");
    private JLabel abteilungen = new JLabel("Abteilungen:");
    private JLabel funktionen = new JLabel("Funktionen:");
    private JLabel teams = new JLabel("Teams:");

    private ListMaker listAbteilungen = new ListMaker("Department", 1);
    private ListMaker listFunctions = new ListMaker("JobFunction", 1);
    private ListMaker listTeams = new ListMaker("Team", 1);

    private JPanel panelName = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel panel = new JPanel(new GridLayout(3,2,2,10));
    private JPanel panelName1 = new JPanel(new BorderLayout());
    private JPanel panelGrid = new JPanel(new FlowLayout(FlowLayout.LEFT));

    public Stammdaten(){
        textField.setColumns(18);

        labelPanel.add(firma, NORTH);
        textFieldPanel.add(textField, NORTH);
        abteilungPanel.add(abteilungen, NORTH);
        funktionPanel.add(funktionen, NORTH);
        teamPanel.add(teams, NORTH);

        setLayout(new BorderLayout());
        textField.setEditable(false);

        panelName.add(labelPanel);
        panelName.add(textFieldPanel);
        panel.add(abteilungPanel);
        panel.add(listAbteilungen);
        panel.add(funktionPanel);
        panel.add(listFunctions);
        panel.add(teamPanel);
        panel.add(listTeams);

        panelName1.add(panelName);
        add(panelName1, NORTH);
        panelGrid.add(panel, WEST);
        add(panelGrid);



        setVisible(true);
    }
}
