package view;

import controller.BackButtonController;
import controller.MoveButtonController;
import model.Game;
import model.GameItem;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bijin on 16-Apr-16.
 */
public class ItemInfo extends JPanel
{
    LabelField troop;
    LabelField health;
    JButton moveButton;
    JButton attackButton;
    JButton backButton;
    JPanel buttonPanel;

    public ItemInfo(Game game, GameGUI view)
    {
        this.setLayout(new GridLayout(0, 1));
        // add labels

        troop = new LabelField("Troop");
        health = new LabelField("Health");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        moveButton = new JButton("Move");
        moveButton.addActionListener(new MoveButtonController(game, view));
        moveButton.setPreferredSize(new Dimension(100, 40));
        moveButton.setEnabled(false);
        attackButton = new JButton("Attack");
        attackButton.setPreferredSize(new Dimension(100, 40));
        attackButton.setEnabled(false);
        backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonController(game, view));
        backButton.setPreferredSize(new Dimension(200, 40));
        buttonPanel.add(moveButton);
        buttonPanel.add(attackButton);
        this.add(troop);
        this.add(health);
        this.add(buttonPanel);
    }

    public void enableButtons(Boolean isEnabled)
    {
        moveButton.setEnabled(isEnabled);
//        attackButton.setEnabled(isEnabled);
    }

    public void setValues(GameItem item)
    {
        if(item!=null)
        {
            troop.setValue(item.getName());
            health.setValue(item.getHealth() + "");
        }
        else
        {
            troop.resetValue();
            health.resetValue();
        }
    }

    public void enableBackButton(Boolean enable)
    {
        buttonPanel.removeAll();
        if (enable)
        {
            buttonPanel.add(backButton);
        }
        else
        {
            buttonPanel.add(moveButton);
            buttonPanel.add(attackButton);
        }
        this.revalidate();
        this.repaint();
    }

    public void reset()
    {
        enableButtons(false);
        setValues(null);
    }

}
