package View;

import Model.*;
import Interfaces.*;
import Utility.CustomFonts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Created by ankurdabral on 12/04/2016.
 * playerStatus panel to
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
        playerName.setFont(CustomFonts.lifeCraft);
        playerName.setForeground(Color.white);
        setPlayer(game.getCurrentPlayer());
        playerName.setOpaque(true);
        this.add(playerName,BorderLayout.NORTH);

        JPanel itemDetails = new JPanel(new GridLayout(2,1));
        top = new ItemInfo(game, view);
        bottom = new ItemWeaponInfo(game, view);
        bottom.setVisible(false);
        //bottom.setVisible(true);

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
        if (item instanceof Unit){
            bottom.setVisible(buttonsEnabled);
            ArrayList<Weapon> Weapon = ((Unit) item).getWeapons();
            bottom.updateList(Weapon);
        }
        else{
            bottom.setVisible(false);
        }
        top.setValues(item);
        top.enableButtons(buttonsEnabled);

    }

//    public void updateWeaponList (GameItem item, ){
//
//    }

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
