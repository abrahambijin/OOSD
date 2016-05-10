package View;

import Controller.WeaponSelectionController;
import Interfaces.Weapon;
import Model.Game;
import Utility.CustomFonts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Bijin on 16-Apr-16.
 * display weapon information about the seleted unit
 */
public class ItemWeaponInfo extends JPanel
{
    private JScrollPane scroll = new JScrollPane();
    private JLabel label = new JLabel();
    private JPanel itemList = new JPanel();
    private JPanel itemStrength = new JPanel();
    private DefaultListModel listItems = new DefaultListModel();
    private JList weaponsList;
    private LabelField powerLevel;


    public ItemWeaponInfo(Game game, GameGUI view)
    {
        this.setLayout(new BorderLayout());
        // adding scroll pane to select item
        itemList.setLayout(new BorderLayout());
        //itemList.setLayout(new FlowLayout(FlowLayout.LEFT,2,20));
        label = new JLabel("Weapons", SwingConstants.LEFT);
        label.setForeground(Color.white);
        label.setFont(CustomFonts.primeTime);
        weaponsList = new JList(listItems);
        weaponsList.addListSelectionListener(
                new WeaponSelectionController(game, view));
        scroll = new JScrollPane(weaponsList);
        //scroll.setPreferredSize(new Dimension(20, 1000));
        //        label.setOpaque(false);
        //        scroll.setOpaque(false);
        itemList.add(label, BorderLayout.PAGE_START);
        itemList.add(scroll);
        itemList.setOpaque(false);
        itemStrength.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 20));
        powerLevel = new LabelField("Power");
        itemStrength.add(powerLevel);
        itemStrength.setOpaque(false);
        //add panels
        this.setOpaque(false);
        this.add(itemList,BorderLayout.WEST);
        this.add(itemStrength);

    }

    public void updateList(ArrayList<Weapon> weapons)
    {
        listItems.clear();
        powerLevel.resetValue();
        for (Weapon w : weapons)
        {
            listItems.addElement(w.getName());
        }
        weaponsList.setSelectedIndex(0);
    }

    public String getSelectedID()
    {
        return (String) weaponsList.getSelectedValue();
    }

    public void updatePowerLevel(Weapon weapon)
    {
        if (weapon != null)
            powerLevel.setValue(weapon.getDamage()+"");
    }


}
