package ch.bzz.view;


import ch.bzz.exception.NotExistingDepartmentException;
import ch.bzz.facade.*;
import ch.bzz.model.company.Department;
import ch.bzz.model.employees.Person;
import ch.bzz.model.log.LogBook;
import ch.bzz.model.log.UserAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.awt.BorderLayout.*;

/**
 * Creats an View
 * @author Niklas Vogel (Nukufel)
 * @since 22.06.2022
 * @version 2
 */
public class UpCreView extends JDialog{
    private List<Department> departmentNameList = new ArrayList<>(ViewComponent.getInstance().getDepartmentList());
    private JDialog pictureDialog = new JDialog();

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Bezeichnung:  ");
    private JButton abbrechen = new JButton("Abbrechen");
    private JButton speichern = new JButton("Speichern");
    private JTextField textField = new JTextField();
    private JLabel infoLabel = new JLabel();

    private JLabel comboLabel = new JLabel("Department:    ");
    private JComboBox<String> comboBox = new JComboBox<>();
    private JPanel labelComboPanel1 = new JPanel(new BorderLayout());
    private JPanel labelComboPanel2 = new JPanel(new BorderLayout());
    private JPanel extraPanel = new JPanel(new GridLayout(3,1,5,10));

    private JPanel picturePanel = new JPanel(new BorderLayout());
    private JLabel pictureLabel = new JLabel();
    private JButton picturButton = new JButton("Change picture");
    private JPanel pictureButtenPanel = new JPanel(new BorderLayout());
    private JPanel picturePanel2 = new JPanel(new BorderLayout());


    private JPanel buttonPanel1 = new JPanel();
    private JPanel buttonPanel2 = new JPanel();
    private JPanel labelTextPanel1 = new JPanel();
    private JPanel labelTextPanel2= new JPanel();

    private String path = "";
    private ListMaker owner;

    /**
     * creates an GUI for adding or correcting person, Department, Team, Function
     * @param what String (for witch itme this upcre vie is)
     * @param modus String (if the UPCreView is for add or correct)
     * @param owner a instance of Listmaker
     */
    public UpCreView(String what, String modus, ListMaker owner){
         for (int i = 0; i<departmentNameList.size(); i++){
            comboBox.addItem(departmentNameList.get(i).getName());
        }
        this.owner = owner;


        setTitle(what+" erfassen/bearbeiten");
        infoLabel.setText(what+" erfassen/bearbeiten");

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

        setSize(300,100);


        if(what == "PersonView") {
            labelComboPanel1.add(comboLabel, WEST);
            labelComboPanel1.add(comboBox, CENTER);
            labelComboPanel2.add(labelComboPanel1, NORTH);

            extraPanel.add(labelTextPanel2);
            extraPanel.add(picturMaker());
            extraPanel.add(labelComboPanel2);

            panel.add(extraPanel, CENTER);
            setSize(300,300);
        }

        add(panel);

        setUndecorated(true);
        setVisible(true);




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
                if (textField.getText()!=null && !textField.getText().isEmpty()) {
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
                    case "PersonView":
                        Person person=new Person(textField.getText().split(" ")[0],textField.getText().split(" ")[1]);
                        try {
                            LogBook.getLogBookInstance().addEntry(new UserAction(ViewComponent.getInstance().getEditor(),person, UserAction.CREATE_PERSON).getEntry());
                            ViewComponent.getInstance().addPerson((String) comboBox.getSelectedItem(), person);
                        } catch (NotExistingDepartmentException | IOException ex) {
                            ex.printStackTrace();
                        }
                        break;
                }
                }else if(modus == "correct") {
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
                        case "PersonView":
                            if (ViewComponent.getInstance().getAllPersonOfCompany().get(owner.getIndex()).getImgPath() == null || !Files.exists(Paths.get(ViewComponent.getInstance().getAllPersonOfCompany().get(owner.getIndex()).getImgPath()))) {
                                pictureLabel.setIcon(new ImageIcon("data/img/standart.png"));
                            } else {
                                pictureLabel.setIcon(new ImageIcon(ViewComponent.getInstance().getAllPersonOfCompany().get(owner.getIndex()).getImgPath()));
                            }
                            try {
                                Person person=ViewComponent.getInstance().getPersonByFullName( owner.getFirstName() + " " + owner.getLastName());
                                LogBook.getLogBookInstance().addEntry(new UserAction(ViewComponent.getInstance().getEditor(),person, UserAction.CHANGE_VALUE).getEntry());
                                ViewComponent.getInstance().correctParson(owner.getFirstName(), owner.getLastName(), getNewFirstName(), getNewLastName(), (String) comboBox.getSelectedItem(), path);
                            } catch (NotExistingDepartmentException | IOException ex) {
                                ex.printStackTrace();
                            }
                            break;
                    }
                }
                dispose();
            }
        }
        });

        picturButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("data/img/"  );
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fileChooser.showOpenDialog(pictureDialog) == JFileChooser.APPROVE_OPTION){
                    path = fileChooser.getSelectedFile().getPath();
                    addPicture(path);
                }
            }
        });
    }

    /**
     * gets you the new last part of the string
     * @return
     */
    public String getNewLastName(){
        String name = textField.getText().split(" ")[1];
        return name;
    }

    /**
     * gets you the new first part of the name
     * @return String
     */
    public String getNewFirstName(){
        String name = textField.getText().split(" ")[0];
        return name;
    }

    /**
     * maks a panel in witch you will add a picture
     * @return a JPpanel
     */
    public JPanel picturMaker(){
         picturePanel.add(pictureLabel, EAST);
         picturePanel2.add(picturePanel, CENTER);
         pictureButtenPanel.add(picturButton, SOUTH);
         picturePanel2.add(pictureButtenPanel, EAST);
         return picturePanel2;
    }

    /**
     * Adds a picture after choosing it
     * @param path
     */
    public void addPicture(String path){
            pictureLabel.setIcon(new ImageIcon(path));
    }




}
