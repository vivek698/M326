package ch.bzz.view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import ch.bzz.facade.ViewComponent;


import static java.awt.BorderLayout.*;

public class PersonView extends JPanel {
    private PersonComponent personComponent;

    private JSeparator separator = new JSeparator();
    private JPanel inDetailPanel2 = new JPanel(new BorderLayout(10,10));

    private JCheckBox hrPerson  = new JCheckBox("HR-Person");
    private JCheckBox admin = new JCheckBox("Admin");
    private JPanel checkboxPanel = new JPanel(new GridLayout(2,1,5,5));
    private JPanel inCheckBoxPanel = new JPanel(new BorderLayout());


    public PersonView(){
        personComponent = new PersonComponent(inDetailPanel2);
        setLayout(new BorderLayout());

        checkboxPanel.add(hrPerson);
        checkboxPanel.add(admin);
        inCheckBoxPanel.add(checkboxPanel, NORTH);

        inDetailPanel2.add(separator,CENTER);
        inDetailPanel2.add(inCheckBoxPanel, SOUTH);

        add(personComponent, CENTER);
        setVisible(true);

    }
}
