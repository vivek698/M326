package ch.bzz.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;


public class ListMaker extends JPanel{
    private JScrollPane scrollPane;
    private JButton addButton = new JButton("+");
    private JButton deleteButton = new JButton("X");
    private JButton corectButton = new JButton("/");
    private JList<String> list = new JList<>();
    private JPanel buttonPanel = new JPanel();
    private Vector<String> data = new Vector<>();

    //Speicher GUI


    public ListMaker(List<String> data){

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


        list.setModel(new TestListModel(data));
    }

}
