package Controller;

import Interfaces.Weapon;
import Model.GameItem;
import Utility.PlayerColor;
import Model.Unit;
import View.GameGUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created by ankurdabral on 10/05/2016.
 */
public class WeaponSelectionController extends GameController implements 
        ListSelectionListener
{
    
    private boolean isActive;

    public WeaponSelectionController(GameGUI view)
    {
        super(view);
        this.isActive = false;
    }


    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting() && isActive)
        {
            String value = super.getView().getPlayerStatus().getBottom().getSelectedID();
            GameItem selectedItem =
                    super.getGame().getItem(super.getView().getPlayerStatus().getItemLocation());
            Weapon weapon = null;
            if (selectedItem instanceof Unit)
                weapon = ((Unit) selectedItem).getWeapon(value);

            if (weapon != null)
            {
                super.getView().getPlayerStatus().getBottom().updatePowerLevel(weapon);
                PlayerColor playerColor = super.getGame().getCurrentPlayer().getColor();
                Color cellColor =
                        new Color(playerColor.getRed(), playerColor.getGreen(),
                                playerColor.getBlue());

                super.getView().getPlayGround().disableButtons(
                        super.getGame().getPossibleShootingOptions(
                                selectedItem.getPosition(), value), cellColor);
            }
        }

    }
    // to set listner active

    public void setIsActive(boolean active)
    {
        this.isActive = active;
    }

}
