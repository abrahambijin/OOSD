package View;

import Interfaces.Weapon;
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
    private DefaultListModel items = new DefaultListModel();
    private JList weapons;


    public ItemWeaponInfo()
    {
        this.setLayout(new GridLayout(0, 2));
        // adding scroll pane to select item
        itemList.setLayout(new BorderLayout());
            label = new JLabel("Weapons", SwingConstants.LEFT);
            label.setForeground(Color.white);
            label.setFont(CustomFonts.primeTime);
            weapons = new JList(items);
            scroll = new JScrollPane(weapons);
//        label.setOpaque(false);
//        scroll.setOpaque(false);
        itemList.add(label, BorderLayout.PAGE_START);
        itemList.add(scroll, BorderLayout.CENTER);
        itemList.setOpaque(false);
        itemStrength.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 20));
        LabelField power = new LabelField("Power");
        itemStrength.add(power);
        itemStrength.setOpaque(false);
        //add panels
        this.setOpaque(false);
        this.add(itemList);
        this.add(itemStrength);

    }

    public void updateList(ArrayList<Weapon> weapons){
        items.clear();
        for(Weapon w: weapons ){
            items.addElement(w.getName());
        }
    }


}
