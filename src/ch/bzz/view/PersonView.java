package ch.bzz.view;

import javax.print.attribute.HashPrintJobAttributeSet;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import ch.bzz.facade.ViewComponent;


import static java.awt.BorderLayout.*;

public class PersonView extends JPanel {
    private PersonComponent personComponent;

    private JSeparator separator = new JSeparator();
    private JLabel label = new JLabel(" ");
    private JPanel seperatorPanel = new JPanel(new BorderLayout(10,10));
    private JPanel inDetailPanel2 = new JPanel(new BorderLayout(10,10));

    private JCheckBox hrPerson  = new JCheckBox("HR-Person");
    private JCheckBox admin = new JCheckBox("Admin");
    private JPanel checkboxPanel = new JPanel(new GridLayout(2,1,5,5));
    private JPanel inCheckBoxPanel = new JPanel(new BorderLayout());



    public PersonView(){
        personComponent = new PersonComponent(inDetailPanel2, 1);
        setLayout(new BorderLayout());

        hrPerson.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String fullName = personComponent.listMaker.getSelectedFullName();

                if (hrPerson.isSelected()) {
                    ViewComponent.getInstance().convertToHRPerson(fullName, 0);
                    new SetPassword(fullName);

                }else {
                    admin.setSelected(false);
                    ViewComponent.getInstance().convertToPerson(fullName);
                }
            }
        });


        admin.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String fullName = personComponent.listMaker.getSelectedFullName();
                if (admin.isSelected()) {
                    hrPerson.setSelected(true);
                    ViewComponent.getInstance().convertToHRPerson(fullName, 1);
                }else{
                    ViewComponent.getInstance().convertToHRPerson(fullName, 0);
                }
            }
        });

        personComponent.listMaker.getSelectedFullName();


        checkboxPanel.add(hrPerson);
        checkboxPanel.add(admin);
        inCheckBoxPanel.add(checkboxPanel, NORTH);

        seperatorPanel.add(label, NORTH);
        seperatorPanel.add(separator, CENTER);
        inDetailPanel2.add(seperatorPanel,NORTH);
        inDetailPanel2.add(inCheckBoxPanel, CENTER);

        add(personComponent, CENTER);
        setVisible(true);

    }


}
