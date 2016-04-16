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

    private ItemInfo top = new ItemInfo();
    private ItemWeaponInfo bottom = new ItemWeaponInfo();

    public PlayerStatus()
    {
        this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(2, 0));
        // divide top panel for label
        bottom = new ItemWeaponInfo();
        top = new ItemInfo();
        this.add(top);
        this.add(bottom);
    }

    public ItemInfo getTop() {
        return top;
    }

    public void setTop(ItemInfo top) {
        this.top = top;
    }

    public ItemWeaponInfo getBottom() {
        return bottom;
    }

    public void setBottom(ItemWeaponInfo bottom) {
        this.bottom = bottom;
    }
}
