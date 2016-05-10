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
            System.out.println(value);
            GameItem selectedItem = game.getItem(view.getPlayerStatus()
                    .getItemLocation());
            Weapon weapon = null;
            if(selectedItem instanceof Unit)
                weapon = ((Unit) selectedItem).getWeapon(value);

            view.getPlayerStatus().getBottom().updatePowerLevel(weapon);
            //Weapon weapon = view.getPlayerStatus().getBottom().getSelectedID();
//            String value = view.getBorrowBookView().getSelectedID().t
//
//            // storing object of book for selected book id
//            LibraryBook book = model.getBook(value);
//            //updating book values in borrow book panel
//            view.getBorrowBookView().updateBookValues(book);
            //view.getPlayerStatus().getBottom().updatePowerLevel(value);
        }

    }
    // to set listner active
    public void setIsActive(boolean active){
        this.isActive = active;
    }

}
