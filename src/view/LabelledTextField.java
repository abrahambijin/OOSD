package view;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by ankurdabral on 13/04/2016.
 */
public class LabelledTextField extends JPanel {
    private JLabel label;
    private JLabel textField;
   // private String position;

    public LabelledTextField (String labelText, String valueText){
        this.setLayout(new BorderLayout());
        //this.setLayout(new FlowLayout(FlowLayout.LEFT));
        //this.position = position;
        this.label = new JLabel(labelText);//new label specified name
        //this.textField = new JTextField(textwidth);//new text field
        this.textField = new JLabel(valueText);
        //with specified length
        //this.setBorder(BorderFactory.createLineBorder(Color.black,1));
        this.add(label, BorderLayout.WEST);
        this.add(textField, BorderLayout.CENTER);
        //this.setPreferredSize(new Dimension(30,5));

    }
    // return the text in textfield
    public String getText() {
        return textField.getText();
    }
    // return textfield
    public JLabel getTextField() {
        return textField;
    }
    // clears items of the textfield
    public void clearItems(){
        textField.setText("");
    }
    // document listner to read input changes in textfield
//    public void addDocumentListner(DocumentListener documentListener){
//        textField.getDocument().addDocumentListener(documentListener);
//    }

}
