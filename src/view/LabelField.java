package view;

import javax.swing.*;
import java.awt.*;

public class LabelField extends JPanel
{

    private String labelName;
    private JLabel label;

    public LabelField(String labelName)
    {
        super(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel();
        label.setFont(new Font("Courier New", Font.BOLD, 14));
        this.labelName = labelName;
        setValue("");
        this.add(label);
    }

    public void setValue(String value)
    {
        label.setText(String.format("%-6s: %s", labelName, value));
    }

    public void resetValue()
    {
        setValue("");
    }

    public void centerHorizontaly()
    {
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

}
