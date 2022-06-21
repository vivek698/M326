package ch.bzz.view;

import ch.bzz.model.log.LogBook;
import ch.bzz.facade.ViewComponent;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LogBookView extends JPanel {

    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane;
    private static LogBook logBookInstace = null;

      public LogBookView(){
          setLayout(new BorderLayout());
          scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scrollPane.add(textArea);
          textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
          add(scrollPane, BorderLayout.CENTER);
          setVisible(true);
      }

      public void setLogBook() throws IOException {
          String text = "";
          for (int i = 0; i< LogBook.getLogBookInstance().getSize();i++){
              text += LogBook.getLogBookInstance().getEntry(i);
          }
          textArea.setText(text);
      }











}
