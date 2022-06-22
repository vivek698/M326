
package ch.bzz.view;

import javax.swing.*;
import java.awt.*;

public class ZuordenenView extends JPanel {
    private PersonComponent personComponent;
    private JPanel panel = new JPanel(new BorderLayout(5,5));

    private ListMaker listFunctions = new ListMaker("JobFunctionForZuordnung", 5);
    private ListMaker listTeams = new ListMaker("TeamForZuordnung", 5);
    private JPanel panel1 = new JPanel(new BorderLayout());
    private JPanel panel2 = new JPanel(new BorderLayout());
    private JPanel panel11 = new JPanel(new BorderLayout());
    private JPanel panel22 = new JPanel(new BorderLayout());
    private JPanel seperatorPanel = new JPanel(new BorderLayout(5,5));
    private JLabel functions = new JLabel("Functions:");
    private JLabel teams = new JLabel("Teams:");

    private JSeparator separator = new JSeparator();

    private JPanel gridPanel = new JPanel(new GridLayout(1,2,10,10));

    public ZuordenenView(){
        setLayout(new BorderLayout(5,5));

        personComponent = new PersonComponent(panel, 0);

        panel11.add(panel1, BorderLayout.CENTER);
        panel11.add(functions, BorderLayout.NORTH);
        panel22.add(panel2, BorderLayout.CENTER);
        panel22.add(teams, BorderLayout.NORTH);

        panel1.add(listFunctions, BorderLayout.NORTH);
        panel2.add(listTeams, BorderLayout.NORTH);

        gridPanel.add(panel11);
        gridPanel.add(panel22);
        seperatorPanel.add(separator, BorderLayout.CENTER);

        panel.add(seperatorPanel, BorderLayout.NORTH);
        panel.add(gridPanel, BorderLayout.CENTER);

        add(personComponent, BorderLayout.CENTER);
        setVisible(true);
    }
}

