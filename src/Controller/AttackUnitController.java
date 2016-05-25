package Controller;

import Model.*;
import View.GameGUI;

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
            GameItem item = super.getGame().getItem(currentLocation);
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
                    System.out.println(super.getGame().getCurrentPlayer().getName() +
                            " won the game");
                    System.exit(0);
                }
            }
            super.getView().getPlayerStatus().getBottom().setVisible(false);
            super.getView().getPlayerStatus().getBottom2()
                    .setVisible(false);
            super.getView().getPlayerStatus().getBottom2().resetButton();
            super.getGame().nextPlayer();
            super.getView().getPlayGround().disableButtons(
                    super.getGame().getOccupiedBoardLocation(), null);
            super.getView().getPlayerStatus()
                    .updatePage(super.getGame().getCurrentPlayer());
            super.getView().getPlayerStatus().getTop().enableBackButton(false);
            GameActionController.setSTATUS(ButtonStatus.NOT_SELECTED);
            super.getView().setStatus(
                    super.getGame().getCurrentPlayer().getName() +
                            ", select the troop you wish to move or attack with");
        }
    }
}
