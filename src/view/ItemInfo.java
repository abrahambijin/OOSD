package View;

import Controller.AttackButtonController;
import Controller.BackButtonController;
import Controller.MoveButtonController;
import Model.Game;
import Model.GameItem;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bijin on 16-Apr-16.
 * display information about the selected item
 */
public class ItemInfo extends JPanel
{
    LabelField unit;
    LabelField health;
    JButton moveButton;
    JButton hitButton;
    JButton undoButton;
    JButton backButton;
    JPanel buttonPanel;

    public ItemInfo(Game game, GameGUI view)
    {

        this.setLayout(new GridLayout(0, 1));

        // add custom label field to show item name and health
        unit = new LabelField("Unit");
        health = new LabelField("Health");

        // adding buttons to move or attack
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
            moveButton = new JButton("Move");
            moveButton.addActionListener(new MoveButtonController(game, view));
            moveButton.setPreferredSize(new Dimension(100, 40));
            moveButton.setEnabled(false);
            hitButton = new JButton("Attack");
            hitButton.addActionListener(new AttackButtonController(game, view));
            hitButton.setPreferredSize(new Dimension(100, 40));
            hitButton.setEnabled(false);
            undoButton = new JButton("Undo");
            //undoButton.addActionListener(new AttackButtonController(game, view));
            undoButton.setPreferredSize(new Dimension(100, 40));
            undoButton.setEnabled(false);
            // back button to undo seleted action
            backButton = new JButton("Back");
            backButton.addActionListener(new BackButtonController(game, view));
            backButton.setPreferredSize(new Dimension(200, 40));
            buttonPanel.setOpaque(false);
            buttonPanel.add(moveButton);
            buttonPanel.add(hitButton);
            buttonPanel.add(undoButton);
        this.setOpaque(false);
        this.add(unit);
        this.add(health);
        this.add(buttonPanel);

    }

    public void enableButtons(Boolean isEnabled)
    {
        moveButton.setEnabled(isEnabled);
        hitButton.setEnabled(isEnabled);
        undoButton.setEnabled(isEnabled);
    }

    // set values of unit name and health
    public void setValues(GameItem item)
    {
        if (item != null)
        {
            unit.setValue(item.getName());
            health.setValue(item.getHealth() + "");
        }
        else
        {
            unit.resetValue();
            health.resetValue();
        }
    }

    //enable/disable back button
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
            buttonPanel.add(hitButton);
            buttonPanel.add(undoButton);
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
