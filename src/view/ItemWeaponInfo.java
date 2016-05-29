package View;

import Controller.WeaponSelectionController;
import Interfaces.Weapon;
import Model.Game;
import Utility.CustomFonts;
import Utility.Posture;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
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
    private JPanel imagePanel = new JPanel();
    private JLabel imageLabel = new JLabel();
    private DefaultListModel listItems = new DefaultListModel();
    private JList weaponsList;
    private LabelField powerLevel;
    private WeaponSelectionController selectionListener;
    private JTextArea weaponInfo;

    public ItemWeaponInfo(Game game, GameGUI view)
    {
        this.setLayout(new BorderLayout());
        // adding scroll pane to select item
        itemList.setLayout(new BorderLayout());
        //itemList.setLayout(new FlowLayout(FlowLayout.LEFT,2,20));
        label = new JLabel("Weapons", SwingConstants.LEFT);
        label.setForeground(Color.white);
        label.setFont(CustomFonts.primeTime);

        selectionListener = new WeaponSelectionController(game, view);

        weaponsList = new JList(listItems);
        weaponsList.setFont(CustomFonts.droidSans);
        weaponsList.addListSelectionListener(selectionListener);
        scroll = new JScrollPane(weaponsList);
        //scroll.setPreferredSize(new Dimension(20, 1000));
        //        label.setOpaque(false);
        //        scroll.setOpaque(false);
        itemList.add(label, BorderLayout.PAGE_START);
        itemList.add(scroll);
        itemList.setOpaque(false);
        //itemStrength.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 20));
        itemStrength.setLayout(new BorderLayout(0, 0));

        powerLevel = new LabelField("Power");
        powerLevel.setBorder(new EmptyBorder(0, 20, 0, 10));
        imagePanel.setLayout(new BorderLayout());
        imageLabel.setForeground(Color.white);
        imageLabel.setOpaque(true);
        imagePanel.add(imageLabel,BorderLayout.WEST);
        imagePanel.setOpaque(false);
        imagePanel.setBorder(new EmptyBorder(30, 20, 10, 0));
        weaponInfo = new JTextArea();
        weaponInfo.setForeground(Color.white);
        weaponInfo.setFont(CustomFonts.chelsea);
        weaponInfo.setOpaque(false);
        weaponInfo.setBorder(new EmptyBorder(0, 22, 0, 10));
        itemStrength.add(imagePanel);
        itemStrength.add(powerLevel);
        itemStrength.add(weaponInfo);
        itemStrength.setLayout(new BoxLayout(itemStrength,BoxLayout.Y_AXIS));
        //imageLabel.setBorder(new EmptyBorder(0,5,0,0));

        itemStrength.setOpaque(false);
        //add panels
        this.setOpaque(false);
        this.add(itemList, BorderLayout.WEST);
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
        {
            powerLevel.setValue(weapon.getDamage() + "");
            imageLabel.setIcon(new ImageIcon(
                    new ImageIcon(weapon.getImage()).getImage()
                            .getScaledInstance(80, 50, Image.SCALE_DEFAULT)));
            imageLabel.repaint();
        }
    }

    public void setListenerStatus(Boolean status)
    {
        selectionListener.setIsActive(status);
    }

    public void setWeaponInfo(Posture info){

        weaponInfo.setText("Unit is in "+info.toString()+" mode \n" +
                " the damage changed by "+info.getValue());
    }


}
