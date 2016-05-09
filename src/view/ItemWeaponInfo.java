package View;

import Utility.CustomFonts;

import javax.swing.*;
import java.awt.*;

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

    public ItemWeaponInfo()
    {
        this.setLayout(new GridLayout(0, 2));
        // adding scroll pane to select item
        itemList.setLayout(new BorderLayout());
            label = new JLabel("Weapons", SwingConstants.LEFT);
            label.setForeground(Color.white);
            label.setFont(CustomFonts.primeTime);
            scroll = new JScrollPane();
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
}
