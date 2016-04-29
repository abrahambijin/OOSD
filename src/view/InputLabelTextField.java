package view;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by ankurdabral on 28/04/2016.
 */
public class InputLabelTextField extends JPanel{

    private JLabel labelName;
    private JTextField textField;

    public InputLabelTextField(String name) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
        labelName = new JLabel(name);
        labelName.setForeground(Color.white);
        labelName.setFont(new Font("Arial",Font.BOLD,14));
        textField = new JTextField(name,20);

        textField.setForeground(Color.white);
        textField.setBackground(new Color(0,0,0,50));
        this.add(labelName);
        this.add(textField);
        this.setOpaque(false);
    }

    public String getTextField() {
        return textField.getText().toString();
    }

}
