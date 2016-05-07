package View;

import Utility.CustomFonts;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by ankurdabral on 28/04/2016.
 * a custom Input textfield with a label
 */
public class InputLabelTextField extends JPanel
{
    private JTextField textField;

    public InputLabelTextField(String name)
    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT,30,0));
        JLabel labelName = new JLabel(name);
        labelName.setForeground(Color.white);
        labelName.setFont(CustomFonts.droidSans);
        textField = new JTextField(name, 20);
        textField.setForeground(Color.white);
        textField.setCaretColor(Color.white);
        textField.setOpaque(false);
        textField.setBackground(new Color(0, 0, 0, 30));
        this.add(labelName);
        this.add(textField);
        this.setOpaque(false);
    }
    // return string value of the textfield
    public String getTextField()
    {
        return textField.getText();
    }

    // check if the textfield is empty
    public boolean isEmpty()
    {
        return textField.getText().isEmpty();
    }


    public void addDocumentListener(DocumentListener documentListener)
    {
        textField.getDocument().addDocumentListener(documentListener);
    }
}
