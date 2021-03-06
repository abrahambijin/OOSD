package Controller;

import Model.*;
import Utility.ButtonStatus;
import Utility.Position;
import View.GameGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Bijin on 11-May-16.
 */
public class AttackUnitController extends GameActionController
{
    public AttackUnitController(GameGUI view, Position location)
    {
        super(view, location);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Position currentLocation =
                super.getView().getPlayerStatus().getItemLocation();
        String selectedWeapon =
                super.getView().getPlayerStatus().getBottom().getSelectedID();

        boolean success = super.getGame()
                .hit(currentLocation, super.getLocation(), selectedWeapon);

        if (success)
        {
            boolean isGameActive = super.getGame().checkGameStatus();
            if (!isGameActive)
            {
                exitSystem(super.getGame().getCurrentPlayer().getName());
            }
            GameItem item = super.getGame().getItem(super.getLocation());
            if (item == null)
                super.getView().getPlayGround()
                        .setButtonImage(super.getLocation(), "");
            else
                super.getView().getPlayGround()
                        .setButtonImage(super.getLocation(),
                                item.getImageIconPath());
        }

        super.getView().getPlayerStatus().getBottom().setVisible(false);
        super.getView().getPlayerStatus().getBottom2().setVisible(false);
        super.getView().getPlayerStatus().getBottom().setListenerStatus(false);
        super.getView().getPlayerStatus().getBottom2().resetButton();

        super.getGame().nextPlayer();
        super.saveGame();
        super.getView().getPlayGround()
                .disableButtons(super.getGame().getOccupiedBoardLocation(),
                        null);
        super.getView().getPlayerStatus()
                .updatePage(super.getGame().getCurrentPlayer());
        super.getView().getPlayerStatus().getTop().enableBackButton(false);
        super.getView().getPlayGround()
                .resetButtonActionListener(ButtonStatus.NOT_SELECTED,
                        getView());
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", select the troop you wish to move or attack with");

    }

    public void exitSystem(String playerName)
    {
        JOptionPane.showMessageDialog(super.getView(), playerName + " has won" +
                " the game");
        super.getView().dispose();
        System.exit(0);
    }

}
