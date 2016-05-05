package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bijin on 16-Apr-16.
 */
public class ItemWeaponInfo extends JPanel
{
    private JScrollPane scroll = new JScrollPane();
    private JLabel label = new JLabel();
    private JPanel itemList = new JPanel();
    private JPanel itemStrength = new JPanel();

    public ItemWeaponInfo()
    {
        //divide bottom panel
        this.setLayout(new GridLayout(0, 2));
        itemList.setLayout(new BorderLayout());
        label = new JLabel("item", SwingConstants.LEFT);
        scroll = new JScrollPane();
        itemList.add(label, BorderLayout.PAGE_START);

        itemList.add(scroll, BorderLayout.CENTER);

        itemStrength.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 20));
        LabelField power = new LabelField("Power");
        itemStrength.add(power);

        //add panels


        this.add(itemList);
        this.add(itemStrength);

    }
}
