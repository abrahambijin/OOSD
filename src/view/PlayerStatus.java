package view;

import model.GameItem;

import javax.swing.*;
import java.awt.*;


/**
 * Created by ankurdabral on 12/04/2016.
 */
public class PlayerStatus extends JPanel
{

    private ItemInfo top = new ItemInfo();
    private ItemWeaponInfo bottom = new ItemWeaponInfo();
    GameItem item;

    public PlayerStatus()
    {
        this.setLayout(new FlowLayout());
        this.setLayout(new GridLayout(2, 0));
        // divide top panel for label
        bottom = new ItemWeaponInfo();
        bottom.setVisible(false);
        top = new ItemInfo();
        this.add(top);
        this.add(bottom);
    }

    public ItemInfo getTop() {
        return top;
    }


    public ItemWeaponInfo getBottom() {
        return bottom;
    }

    public void setBottom(ItemWeaponInfo bottom) {
        this.bottom = bottom;
    }

    public GameItem getItem()
    {
        return item;
    }

    public void setItem(GameItem item)
    {
        this.item = item;
    }
}
