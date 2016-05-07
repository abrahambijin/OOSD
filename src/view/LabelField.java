package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import Utility.CustomFonts;
/*
* custom labels with labels and labelvalues to update game information
* */
public class LabelField extends JPanel
{
    private JLabel label, labelValue;

    public LabelField(String labelName)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel(labelName + ": ");
        labelValue = new JLabel("");
        label.setFont(CustomFonts.primeTime);
        label.setForeground(Color.white);
        labelValue.setBorder(new EmptyBorder(3, 0, 0, 10));
        labelValue.setFont(CustomFonts.chelsea);
        labelValue.setForeground(Color.white);
        this.add(label);
        this.add(labelValue);
        this.setOpaque(false);
    }

    public void setValue(String value)
    {
        labelValue.setText(value);
    }

    public void resetValue()
    {
        setValue("");
    }

}
