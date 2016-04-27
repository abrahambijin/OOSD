package view;

import javax.swing.*;
import java.awt.*;

public class LabelField extends JPanel
{

    private String labelName;
    private JLabel label, label1;

    public LabelField(String labelName)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel(labelName);
        label1 = new JLabel("");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        //this.labelName = labelName;
        label.setForeground(Color.white);
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        label1.setForeground(Color.white);
        //setValue("");
        this.add(label);
        this.add(label1);
        this.setOpaque(false);
    }

//    public void setValue(String value)
//    {
//        label.setText(String.format("%-6s: %s", labelName, value));
//    }

    public void setValue(String value)
    {
        label1.setText(value);
    }

    public void resetValue()
    {
        setValue("");
    }

}
