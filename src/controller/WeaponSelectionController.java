package Controller;

import Interfaces.Weapon;
import Model.Game;
import Model.GameItem;
import Model.PlayerColor;
import Model.Unit;
import View.GameGUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 10/05/2016.
 */
public class WeaponSelectionController implements ListSelectionListener
{

    private Game game;
    private GameGUI view;
    private boolean isActive;

    public WeaponSelectionController(Game game, GameGUI view)
    {
        this.game = game;
        this.view = view;
        this.isActive = false;
    }


    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting() && isActive)
        {
            String value = view.getPlayerStatus().getBottom().getSelectedID();
            GameItem selectedItem =
                    game.getItem(view.getPlayerStatus().getItemLocation());
            Weapon weapon = null;
            if (selectedItem instanceof Unit)
                weapon = ((Unit) selectedItem).getWeapon(value);

            if (weapon != null)
            {
                view.getPlayerStatus().getBottom().updatePowerLevel(weapon);
                PlayerColor playerColor = game.getCurrentPlayer().getColor();
                Color cellColor =
                        new Color(playerColor.getRed(), playerColor.getGreen(),
                                playerColor.getBlue());

                view.getPlayGround().disableButtons(
                        game.getPossibleShootingOptions(
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
