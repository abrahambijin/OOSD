package Controller;

import Model.*;
import View.GameGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Bijin on 11-May-16.
 */
public class AttackUnitController extends GameActionController
{
    public AttackUnitController(Game game, GameGUI view, Position location)
    {
        super(game, view, location);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (GameActionController.getSTATUS() == ButtonStatus.SELECTED_TO_ATTACK)
        {
            Position currentLocation =
                    super.getView().getPlayerStatus().getItemLocation();
            String selectedWeapon =
                    super.getView().getPlayerStatus().getBottom()
                            .getSelectedID();

            boolean success = super.getGame()
                    .hit(currentLocation, super.getLocation(), selectedWeapon);

            if (success)
            {
                boolean isGameActive = super.getGame().checkGameStatus();
                if (!isGameActive)
                {
                    exitSystem(super.getGame().getCurrentPlayer().getName());
                }
            }
            super.getView().getPlayerStatus().getBottom().setVisible(false);
            super.getView().getPlayerStatus().getBottom2().setVisible(false);
            super.getView().getPlayerStatus().getBottom().setListenerStatus(false);
            super.getView().getPlayerStatus().getBottom2().resetButton();
            super.getGame().nextPlayer();
            super.getView().getPlayGround()
                    .disableButtons(super.getGame().getOccupiedBoardLocation(),
                            null);
            super.getView().getPlayerStatus()
                    .updatePage(super.getGame().getCurrentPlayer());
            super.getView().getPlayerStatus().getTop().enableBackButton(false);
            GameActionController.setSTATUS(ButtonStatus.NOT_SELECTED);
            super.getView().setStatus(
                    super.getGame().getCurrentPlayer().getName() +
                            ", select the troop you wish to move or attack with");
        }
    }

    public void exitSystem(String playerName)
    {
        JOptionPane.showMessageDialog(super.getView(), playerName + " has won" +
                " the game");
        super.getView().dispose();
        System.exit(0);
    }

}
