package view;

import model.Player;
import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bijin on 16-Apr-16.
 */
public class ItemInfo extends JPanel{
    private JLabel playerName = new JLabel();
    private JPanel buttonPanel = new JPanel();
    public ItemInfo() {
        this.setLayout(new GridLayout(0, 1));
        // add labels
        playerName =new JLabel("Player : ", SwingConstants.CENTER);
        playerName.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        playerName.setFont(new Font("Times New Roman",Font.BOLD,24));
        playerName.setOpaque(true);
        //playerName.setBackground(Color.red);

        LabelField weapon = new LabelField("Weapon");
        LabelField health = new LabelField("Health");
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());
        JButton move = new JButton("Move");
        move.setPreferredSize(new Dimension(100, 40));
        JButton attack = new JButton("Attack");
        attack.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(move);
        buttonPanel.add(attack);
        this.add(playerName);
        this.add(weapon);
        this.add(health);
        this.add(buttonPanel);
    }


        public void setPlayerName(Player player)
    {
        playerName.setText("Player : " + player.getName());
        PlayerColor playerColor =  player.getColor();
        playerName.setBackground(
                new Color(playerColor.getRed(), playerColor.getGreen(),
                        playerColor.getBlue()));

    }
}
