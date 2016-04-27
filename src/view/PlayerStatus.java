package view;

import model.*;

import javax.swing.*;
import java.awt.*;


/**
 * Created by ankurdabral on 12/04/2016.
 */
public class PlayerStatus extends JPanel
{

    private JLabel playerName = new JLabel();
    private ItemInfo top;
    private ItemWeaponInfo bottom;
    private Position itemLocation;

    public PlayerStatus(Game game, GameGUI view)
    {
        this.setLayout(new BorderLayout());

        playerName = new JLabel("Player : ", SwingConstants.CENTER);
        playerName.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        playerName.setPreferredSize(new Dimension(playerName.getWidth(),75));
        playerName.setFont(new Font("Arial Black",Font.BOLD,30));
        playerName.setForeground(Color.white);
        setPlayer(game.getCurrentPlayer());
        playerName.setOpaque(true);
        this.add(playerName,BorderLayout.NORTH);

        JPanel itemDetails = new JPanel(new GridLayout(2,1));
        top = new ItemInfo(game, view);
        bottom = new ItemWeaponInfo();
        bottom.setVisible(false);
        itemDetails.setOpaque(false);
        itemDetails.add(top);
        itemDetails.add(bottom);
        this.setOpaque(false);
        this.add(itemDetails);
    }

    public ItemInfo getTop() {
        return top;
    }


    public ItemWeaponInfo getBottom() {
        return bottom;
    }


    public Position getItemLocation()
    {
        return itemLocation;
    }

    public void setItem(GameItem item, boolean buttonsEnabled)
    {
        itemLocation = item.getPosition();
        top.setValues(item);
        top.enableButtons(buttonsEnabled);
    }

    public void setPlayer(Player player)
    {
        playerName.setText(player.getName());
        PlayerColor playerColor = player.getColor();
        playerName.setBackground(
                new Color(playerColor.getRed(), playerColor.getGreen(),
                        playerColor.getBlue()));
    }

    public void updatePage(Player player)
    {
        setPlayer(player);
        top.reset();
    }
}
