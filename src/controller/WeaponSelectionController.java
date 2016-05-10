package Controller;

import Interfaces.Weapon;
import Model.Game;
import Model.GameItem;
import Model.Unit;
import View.GameGUI;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 10/05/2016.
 */
public class WeaponSelectionController implements ListSelectionListener {

    private Game game;
    private GameGUI view;
    private boolean isActive;
    public WeaponSelectionController(Game game, GameGUI view) {
        this.game = game;
        this.view = view;
        this.isActive = true;
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && isActive){
            String value = view.getPlayerStatus().getBottom().getSelectedID();
            GameItem selectedItem = game.getItem(view.getPlayerStatus()
                    .getItemLocation());
            Weapon weapon = null;
            if(selectedItem instanceof Unit)
                weapon = ((Unit) selectedItem).getWeapon(value);

            view.getPlayerStatus().getBottom().updatePowerLevel(weapon);
        }

    }
    // to set listner active
    public void setIsActive(boolean active){
        this.isActive = active;
    }

}
