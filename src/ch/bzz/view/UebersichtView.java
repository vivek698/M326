package ch.bzz.view;

import javax.swing.*;
import java.awt.*;

/**
 * Creates the StartView with the TabbedPane
 * @author Niklas Vogel (Nukufel)
 * @since 22.06.2022
 * @version 2
 */
public class UebersichtView extends JPanel{
    private PersonComponent personComponent;
    private JPanel panel = new JPanel(new BorderLayout());

    /**
     * Creates the UebersichtView
     */
    public UebersichtView(){
        setLayout(new BorderLayout());
        personComponent = new PersonComponent(panel, 0);



        add(personComponent);
        setVisible(true);
    }
}
