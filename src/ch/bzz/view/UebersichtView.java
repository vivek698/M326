package ch.bzz.view;

import javax.swing.*;

public class UebersichtView extends JPanel{
    private PersonComponent personComponent;
    private JPanel panel = new JPanel();
    public UebersichtView(){
        personComponent = new PersonComponent(panel);



        add(personComponent);
        setVisible(true);
    }
}
