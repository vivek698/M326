package ch.bzz.view;

import javax.swing.*;
import java.awt.*;

public class UebersichtView extends JPanel{
    private PersonComponent personComponent;
    private JPanel panel = new JPanel(new BorderLayout());
    public UebersichtView(){
        setLayout(new BorderLayout());
        personComponent = new PersonComponent(panel, 0);



        add(personComponent);
        setVisible(true);
    }
}
