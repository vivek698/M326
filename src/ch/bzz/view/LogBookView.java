package ch.bzz.view;

import ch.bzz.facade.ViewComponent;
import ch.bzz.model.log.LogBook;
import ch.bzz.model.log.UserAction;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LogBookView extends JPanel {

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private static LogBook logBookInstace;

      public LogBookView(){

          try {
              logBookInstace=LogBook.getLogBookInstance();
          } catch (IOException e) {
              e.printStackTrace();
          }


          textArea=new JTextArea();

          String text="";
          for (int i = 0; i < logBookInstace.getSize(); i++) {
              text+=logBookInstace.getEntry(i)+"\n";
          }

          textArea.setText(text);


          textArea.setEditable(false);
          textArea.setLineWrap(true);
          textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

          setLayout(new BorderLayout());
          scrollPane = new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

          add(scrollPane, BorderLayout.CENTER);
          setVisible(true);

          ViewComponent.getInstance().setLogBookView(this);
      }

      public void setLogBookText() throws IOException {
          String text = "";
          for (int i = 0; i< logBookInstace.getSize();i++){
              text += logBookInstace.getEntry(i)+"\n";
          }
          textArea.setText(text);
      }
}
