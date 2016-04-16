package view;

import model.Game;
import model.Player;
import model.PlayerColor;
import model.PlayerOne;
import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Created by ankurdabral on 12/04/2016.
 */
public class PlayerStatus extends JPanel
{
    private JLabel playerName = new JLabel();
    private JPanel top = new JPanel();
    private JPanel bottom = new JPanel();
    ;
    private JPanel bottomLeft = new JPanel();
    private JPanel bottomRight = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JButton move = new JButton();
    private JButton attack = new JButton();

    // private LabelledTextField textField = new LabelledTextField();

    public PlayerStatus()
    {
        this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(2, 0));
        // divide top panel for label
        top.setLayout(new GridLayout(0, 1));
        // add labels
        playerName = new JLabel("Player : ", SwingConstants.CENTER);
        playerName.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        playerName.setOpaque(true);
        //playerName.setBackground(Color.red);

        LabelField weapon = new LabelField("Weapon");
        LabelField health = new LabelField("Health");
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());
        move = new JButton("Move");
        move.setPreferredSize(new Dimension(100, 40));
        attack = new JButton("Attack");
        attack.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add(move);
        buttonPanel.add(attack);
        top.add(playerName);
        top.add(weapon);
        top.add(health);
        top.add(buttonPanel);


        //divide bottom panel
        bottom.setLayout(new GridLayout(0, 2));
        bottomLeft.setLayout(new BorderLayout());
        JLabel item = new JLabel("item", SwingConstants.LEFT);
        JScrollPane scroll = new JScrollPane();
        bottomLeft.add(item, BorderLayout.PAGE_START);
        bottomLeft.add(item, BorderLayout.PAGE_START);
        bottomLeft.add(scroll, BorderLayout.CENTER);

        bottomRight.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 20));
        LabelField power = new LabelField("Power");
        bottomRight.add(power);

        //add panels


        bottom.add(bottomLeft);
        bottom.add(bottomRight);
        this.add(top);
        this.add(bottom);
    }

    public void setPlayerName(Player player)
    {
        playerName.setText("Player : " + player.getName());
        PlayerColor playerColor = player.getColor();

        playerName.setBackground(
                new Color(playerColor.getRed(), playerColor.getGreen(),
                        playerColor.getBlue()));

    }


}
