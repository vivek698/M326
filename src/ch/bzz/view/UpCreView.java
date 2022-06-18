package ch.bzz.view;

import ch.bzz.facade.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class UpCreView extends JDialog{
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Bezeichnung:  ");
    private JButton abbrechen = new JButton("Abbrechen");
    private JButton speichern = new JButton("Speichern");
    private JTextField textField = new JTextField();
    private JLabel infoLabel = new JLabel("Funktion erfassen/bearbeiten");


    private JPanel buttonPanel1 = new JPanel();
    private JPanel buttonPanel2 = new JPanel();
    private JPanel labelTextPanel1 = new JPanel();
    private JPanel labelTextPanel2= new JPanel();

    public UpCreView(String what, String modus, ListMaker owner){
        setTitle("Funktion erfassen/bearbeiten");

        textField.setColumns(30);

        panel.setLayout(new BorderLayout(2,15));
        buttonPanel1.setLayout(new GridLayout(1,2,5,5));
        buttonPanel2.setLayout(new BorderLayout());
        labelTextPanel1.setLayout(new BorderLayout());
        labelTextPanel2.setLayout(new BorderLayout());


        buttonPanel1.add(abbrechen);
        buttonPanel1.add(speichern);
        buttonPanel2.add(buttonPanel1, EAST);

        labelTextPanel2.add(labelTextPanel1, NORTH);
        panel.add(buttonPanel2, SOUTH);
        labelTextPanel1.add(label, WEST);
        labelTextPanel1.add(textField, CENTER);
        panel.add(labelTextPanel2, CENTER);
        panel.add(infoLabel, NORTH);


        add(panel);

        setUndecorated(true);
        setVisible(true);
        setSize(300,100);



        abbrechen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                dispose();
            }
        });

        speichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modus == "add"){
                switch (what) {
                    case "Department":
                        ViewComponent.getInstance().addDepartment(textField.getText());
                        break;
                    case "JobFunction":
                        ViewComponent.getInstance().addJobFunction(textField.getText());
                        break;
                    case "Team":
                        ViewComponent.getInstance().addTeam(textField.getText());
                        break;
                }
                }else if(modus == "correct"){
                    switch (what) {
                        case "Department":
                            ViewComponent.getInstance().correctDepartment(textField.getText(), owner.getIndex());
                            break;
                        case "JobFunction":
                            ViewComponent.getInstance().correctJobFunction(owner.getIndex(), textField.getText());
                            break;
                        case "Team":
                            ViewComponent.getInstance().correctTeam(owner.getIndex(), textField.getText());
                            break;
                }
            }
            dispose();
        }
        });
    }

}
