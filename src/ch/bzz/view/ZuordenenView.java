
package ch.bzz.view;

import javax.swing.*;
import java.awt.*;

public class ZuordenenView extends JPanel {
    private PersonComponent personComponent;
    private JPanel panel = new JPanel();

    private ListMaker listFunctions = new ListMaker("JobFunctionForZuordnung", 0);
    private ListMaker listAbteilungen = new ListMaker("DepartmentForTeam", 0);

    public ZuordenenView(){
        setLayout(new BorderLayout());
        personComponent = new PersonComponent(panel, 0);
        add(personComponent, BorderLayout.CENTER);
        setVisible(true);
    }
}

