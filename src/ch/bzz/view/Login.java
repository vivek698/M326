package ch.bzz.view;


import ch.bzz.facade.ViewComponent;
import ch.bzz.model.employees.HRPerson;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;


public class Login extends JDialog{

    JComboBox<String> hrPersonComboBox = new JComboBox<>();

    JPasswordField passwordField = new JPasswordField(15);

    public Login() {
        super();
        setTitle("Login");
        setModal(true);
        setLayout(new GridLayout(3, 2));

        for (HRPerson person:ViewComponent.getInstance().getAllHRPerson()) {
            hrPersonComboBox.addItem(person.getFullName());
        }

        add(new JLabel("Username:"));
        add(hrPersonComboBox);

        add(new JLabel("Password"));
        add(passwordField);

        JButton submit = new JButton("done");
        add(new Panel());
        add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HRPerson person= ViewComponent.getInstance().getAllHRPerson().get(  hrPersonComboBox.getSelectedIndex()  );
                if (person.getPassword().equals(new String(passwordField.getPassword()))){
                    dispose();
                }else{
                    passwordField.setText("");
                }
            }
        });
        pack();
        setVisible(true);
    }
}
