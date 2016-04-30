package view;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by ankurdabral on 28/04/2016.
 */
public class InputLabelTextField extends JPanel
{

    private JTextField textField;

    public InputLabelTextField(String name)
    {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel labelName = new JLabel(name);
        labelName.setForeground(Color.white);
        labelName.setFont(new Font("Arial", Font.BOLD, 14));
        textField = new JTextField(name, 20);

        textField.setForeground(Color.white);
        textField.setCaretColor(Color.white);
        textField.setOpaque(false);
        //textField.setBackground(new Color(61, 61, 61));
        this.add(labelName);
        this.add(textField);
        this.setOpaque(false);
    }

    public String getTextField()
    {
        return textField.getText();
    }

    public boolean isEmpty()
    {
        return textField.getText().isEmpty();
    }

    public void addDocumentListener(DocumentListener documentListener)
    {
        textField.getDocument().addDocumentListener(documentListener);
    }
}
