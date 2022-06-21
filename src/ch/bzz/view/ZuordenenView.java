
package ch.bzz.view;

import javax.swing.*;
import java.awt.*;

public class ZuordenenView extends JPanel {
    private PersonComponent personComponent;
    private JPanel panel = new JPanel();

    public ZuordenenView(){
        setLayout(new BorderLayout());
        personComponent = new PersonComponent(panel);
        add(personComponent, BorderLayout.CENTER);
        setVisible(true);
    }
}

