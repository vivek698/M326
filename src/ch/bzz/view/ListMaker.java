package ch.bzz.view;

import ch.bzz.facade.ViewComponent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ListMaker extends JPanel{
    private JScrollPane scrollPane;
    private JButton addButton = new JButton("+");
    private JButton deleteButton = new JButton("X");
    private JButton corectButton = new JButton("/");
    private JList<String> list = new JList<>();
    private JPanel buttonPanel = new JPanel();
    private ListMaker listMaker;

    //Speicher GUI


    public ListMaker(String art){
        listMaker = this;

        list.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        scrollPane = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);

        this.setMaximumSize(new Dimension(100,100));
        this.setMinimumSize(new Dimension(100,100));
        this.setSize(100,100);

        buttonPanel.setLayout(new GridLayout(1,3,5,0));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(corectButton);

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);


        list.setModel(new TestListModel(art));


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpCreView(art,"add",listMaker);
            }
        });

        corectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UpCreView(art, "correct",listMaker);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (art) {
                    case "Department":
                       ViewComponent.getInstance().deleteDepartment(getIndex());
                        break;
                    case "JobFunction":
                        ViewComponent.getInstance().deleteJobFunction(getIndex());
                        break;
                    case "Team":
                        ViewComponent.getInstance().deleteTeam(getIndex());
                        break;
                    case "PersonView":
                        ViewComponent.getInstance().deletePerson(getFirstName(), getLastName());
                        break;
                    case "JobFunctionForZuordnung":
                        ViewComponent.getInstance().deleteJobFunctionForZuordnung(getIndex());
                        break;
                    case "TeamForZuordnung":
                        ViewComponent.getInstance().deleteTeamForZuordnung(getIndex());
                        break;
                }
            }
        });



    }

    public int getIndex(){
        return list.getSelectedIndex();
    }

    public String getFirstName(){
        String firstName = list.getSelectedValue();
        firstName = firstName.split(" ")[0];
        return firstName;
    }

    public String getLastName() {
        String lastName = list.getSelectedValue();
        lastName = lastName.split(" ")[1];
        return lastName;
    }

    public String getSelectedFullName(){
        if (list.getSelectedValue()==null){
            return "Vorname Nachname";
        }else {
            return (String) list.getSelectedValue();
        }
    }




    public void addListSelectionListener(ListSelectionListener listSelectionListener) {
        list.addListSelectionListener(listSelectionListener);
    }
}
