package view;

import model.GameItem;
import model.Player;
import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bijin on 16-Apr-16.
 */
public class ItemInfo extends JPanel
{
    private JLabel playerName = new JLabel();
    LabelField troop;
    LabelField health;
    JButton moveButton;
    JButton attackButton;
    JButton backButton;
    JPanel buttonPanel;

    public ItemInfo(Player player)
    {
        this.setLayout(new GridLayout(0, 1));
        // add labels
        playerName = new JLabel("Player : ", SwingConstants.CENTER);
        playerName.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        //playerName.setFont(new Font("Times New Roman",Font.BOLD,24));
        setPlayer(player);
        playerName.setOpaque(true);

        troop = new LabelField("Troop");
        health = new LabelField("Health");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        moveButton = new JButton("Move");
        moveButton.setPreferredSize(new Dimension(100, 40));
        moveButton.setEnabled(false);
        attackButton = new JButton("Attack");
        attackButton.setPreferredSize(new Dimension(100, 40));
        attackButton.setEnabled(false);
        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 40));
        buttonPanel.add(moveButton);
        buttonPanel.add(attackButton);
        this.add(playerName);
        this.add(troop);
        this.add(health);
        this.add(buttonPanel);
    }


    public void setPlayer(Player player)
    {
        playerName.setText("Player : " + player.getName());
        PlayerColor playerColor = player.getColor();
        playerName.setBackground(
                new Color(playerColor.getRed(), playerColor.getGreen(),
                        playerColor.getBlue()));
    }

    public void setMoveEnabled(Boolean moveEnabled)
    {
        moveButton.setEnabled(moveEnabled);
    }

    public void setValues(GameItem item)
    {
        troop.setValue(item.getName());
        health.setValue(item.getHealth() + "");
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
    }

}
