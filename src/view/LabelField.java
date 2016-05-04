package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import utility.CustomFonts;

public class LabelField extends JPanel
{

    private String labelName;
    private JLabel label, label1;

    public LabelField(String labelName)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel(labelName + ": ");
        label1 = new JLabel("");
        //label.setFont(new Font("Impact", Font.BOLD, 20));
        //this.labelName = labelName;
        label.setFont(CustomFonts.primeTime);
        label.setForeground(Color.white);

        label1.setBorder(new EmptyBorder(3, 0, 0, 0));
        //label1.setFont(new Font("sans serif", Font.PLAIN, 18));
        //label1.setLayout(new FlowLayout());
        label1.setFont(CustomFonts.chelsea);
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
