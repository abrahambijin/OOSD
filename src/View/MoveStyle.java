package View;

import Model.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

/**
 * Created by ankurdabral on 18/05/2016.
 */
public class MoveStyle extends JPanel{
    private JRadioButton normal,defence,attack;
    private ButtonGroup movement = new ButtonGroup();
    public MoveStyle(Game game, GameGUI view) {
        this.setLayout(new BorderLayout());
        this.setLayout(new GridLayout(0,1));
        normal = new JRadioButton("Normal",true);
        normal.setForeground(Color.white);
        defence = new JRadioButton("Defence");
        defence.setForeground(Color.white);
        attack = new JRadioButton("Attack");
        attack.setForeground(Color.white);

        movement.add(normal);
        movement.add(defence);
        movement.add(attack);

        this.setOpaque(false);
        this.add(normal, BorderLayout.WEST);
        this.add(defence,BorderLayout.WEST);
        this.add(attack,BorderLayout.WEST);

    }

    public void resetButton(){
      normal.setSelected(true);
    }

}
