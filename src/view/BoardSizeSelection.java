package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ankurdabral on 29/04/2016.
 */
public class BoardSizeSelection extends JPanel{
    private JComboBox boardSize;
    private JLabel label;
    private String[] sizeValue = {"Small","Medium","Large"};

    public BoardSizeSelection() {
        boardSize = new JComboBox(sizeValue);
        boardSize.setSelectedIndex(0);
        label = new JLabel("Select Board Size");
        label.setForeground(Color.white);
        label.setFont(new Font("Arial",Font.BOLD,14));
        this.setLayout(new FlowLayout(FlowLayout.LEFT,10,2));
        this.setOpaque(false);
        this.add(label);
        this.add(boardSize);
    }

//    public JComboBox getBoardSize() {
//        return boardSize.ge;
//    }

    public String getSelectedItem() {
        return ((String) boardSize.getSelectedItem()).toString();
    }
}
