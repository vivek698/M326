package ch.bzz.view;


import ch.bzz.facade.ViewComponent;
import ch.bzz.model.employees.HRPerson;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * JDialog for Seting the Passwort
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 22.06.2020
 */
public class SetPassword extends JDialog{


    private JPasswordField passwordField = new JPasswordField(15);
    private JPasswordField passwordFieldConfirm = new JPasswordField(15);
    private HRPerson hrPerson;

    /**
     * Creates SetPassword
     * @param fullName of HrPerson
     */
    public SetPassword(String fullName) {
        super();
        hrPerson = (HRPerson) ViewComponent.getInstance().getPersonByFullName(fullName);

        setTitle("Set Password");
        setModal(true);
        setLayout(new GridLayout(3, 2));


        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel("Password bestätigen:"));
        add(passwordFieldConfirm);

        JButton submit = new JButton("done");
        add(new Panel());
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((new String(passwordField.getPassword())).equals(new String(passwordFieldConfirm.getPassword()))){
                    ViewComponent.getInstance().setPasswordPerson(hrPerson,(new String(passwordField.getPassword())));
                    dispose();
                }else{
                    passwordField.setText("");
                    passwordFieldConfirm.setText("");
                }
            }
        });


        pack();
        setVisible(true);
    }
}
