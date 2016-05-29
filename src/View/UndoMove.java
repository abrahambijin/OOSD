package View;

import Utility.CustomFonts;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

/**
 * Created by ankurdabral on 30/05/2016.
 */
public class UndoMove extends JPanel {

    public JRadioButton move_1, move_2, move_3;
    public ButtonGroup move = new ButtonGroup();

    public UndoMove() {
        this.setLayout(new GridLayout(0, 1));

        move_1 = new JRadioButton("1", true);
        move_2 = new JRadioButton("2");
        move_3 = new JRadioButton("3");

        move_1.setOpaque(false);
        move_2.setOpaque(false);
        move_3.setOpaque(false);


        move.add(move_1);
        move.add(move_2);
        move.add(move_3);

        this.setOpaque(false);
        this.add(move_1);
        this.add(move_2);
        this.add(move_3);
    }



    public void resetButton()
    {
        move_1.setSelected(true);
    }

    public String getSelected()
    {
        for (Enumeration<AbstractButton> buttons = move.getElements(); buttons
                .hasMoreElements();)
        {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

}
