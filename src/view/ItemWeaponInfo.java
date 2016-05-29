package View;

import Controller.WeaponSelectionController;
import Interfaces.Weapon;
import Utility.CustomFonts;
import Utility.LabelField;
import Utility.Posture;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Bijin on 16-Apr-16.
 * display weapon information about the seleted unit
 */
public class ItemWeaponInfo extends JPanel
{
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

    public ItemWeaponInfo(GameGUI view)
    {
        this.setLayout(new BorderLayout());
        //adding scroll pane to select item
        itemList.setLayout(new BorderLayout());
        label = new JLabel("Weapons", SwingConstants.LEFT);
        label.setForeground(Color.white);
        label.setFont(CustomFonts.primeTime);

        //new actionListner to read item from list
        selectionListener = new WeaponSelectionController(view);


        weaponsList = new JList(listItems);
        weaponsList.setFont(CustomFonts.droidSans);
        weaponsList.addListSelectionListener(
                selectionListener); // add actionlistner to weapon list

        //adding scroll pane
        JScrollPane scroll = new JScrollPane(weaponsList);
        itemList.add(label, BorderLayout.PAGE_START);
        itemList.add(scroll);
        itemList.setOpaque(false);
        itemStrength.setLayout(new BorderLayout(0, 0));

        powerLevel = new LabelField(
                "Power"); // label fiel to show power level of weapon
        powerLevel.setBorder(new EmptyBorder(0, 20, 0, 10));

        //new panel to add image of weapon
        imagePanel.setLayout(new BorderLayout());
        imageLabel.setForeground(Color.white);
        imageLabel.setOpaque(true);
        imagePanel
                .add(imageLabel, BorderLayout.WEST); //add image label to panel
        imagePanel.setOpaque(false);
        imagePanel.setBorder(new EmptyBorder(30, 20, 10, 0));

        //text area to show posture and its value
        weaponInfo = new JTextArea();
        weaponInfo.setForeground(Color.white);
        weaponInfo.setFont(CustomFonts.chelsea);
        weaponInfo.setOpaque(false);
        weaponInfo.setBorder(new EmptyBorder(0, 22, 0, 10));

        //adding to single panel
        itemStrength.add(imagePanel);
        itemStrength.add(powerLevel);
        itemStrength.add(weaponInfo);
        itemStrength.setLayout(new BoxLayout(itemStrength, BoxLayout.Y_AXIS));
        itemStrength.setOpaque(false);

        //add panels
        this.setOpaque(false);
        this.add(itemList, BorderLayout.WEST);
        this.add(itemStrength);

    }

    public void updateList(
            ArrayList<Weapon> weapons) //update weapon list according to units
    {
        listItems.clear();
        powerLevel.resetValue();
        for (Weapon w : weapons)
        {
            listItems.addElement(w.getName());
        }
        weaponsList.setSelectedIndex(0);
    }

    public String getSelectedID()  //get selected weapon
    {
        return (String) weaponsList.getSelectedValue();
    }

    public void updatePowerLevel(Weapon weapon) //updates weapon power and
    //image according to selection
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

    public void setListenerStatus(Boolean status) //enable/disable weapon list
    {
        selectionListener.setIsActive(status);
    }

    public void setWeaponInfo(Posture info)
    { //update posture information

        int value = info.getValue();
        String change = info.getValue() > 0 ? "The damage is increased " +
                "by" + value : info.getValue() < 0 ? "The damage is decreased" +
                " by" + (value * -1) : "";

        weaponInfo.setText("Unit is in " + info.toString() + " mode \n" +
                change);
    }


}
