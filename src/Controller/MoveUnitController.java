package Controller;

import Model.*;
import Utility.Posture;
import View.GameGUI;

import java.awt.event.ActionEvent;

/**
 * Created by Bijin on 11-May-16.
 */
public class MoveUnitController extends GameActionController
{
    public MoveUnitController(GameGUI view, Position location)
    {
        super(view, location);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (GameActionController.getSTATUS() == ButtonStatus.SELECTED_TO_MOVE)
        {
            Position currentLocation =
                    super.getView().getPlayerStatus().getItemLocation();
            GameItem item = super.getGame().getItem(currentLocation);

            boolean success =
                    super.getGame().move(currentLocation, super.getLocation());

            if (success)
            {
                if (item instanceof Tower)
                {
                    super.getView().getPlayGround()
                            .setButtonImage(currentLocation,
                                    item.getImageIconPath());
                }

                else
                {
                    super.getView().getPlayGround()
                            .moveItem(currentLocation, super.getLocation(),
                                    item.getImageIconPath());
                }

                String movePosture = super.getView().getPlayerStatus()
                        .getSelectedMovePosture();

                if(movePosture!=null && item instanceof Unit)
                    ((Unit) item).setPosture(Posture.getPosture(movePosture));

                super.getView().getPlayerStatus().getBottom().setVisible(false);
                super.getView().getPlayerStatus().getBottom2().setVisible(false);
                super.getView().getPlayerStatus().getBottom2().resetButton();
                super.saveGame();
                super.getGame().nextPlayer();
                super.getView().getPlayGround().disableButtons(
                        super.getGame().getOccupiedBoardLocation(), null);
                super.getView().getPlayerStatus()
                        .updatePage(super.getGame().getCurrentPlayer());
            }
            //super.getView().getPlayerStatus().getBottom2().resetButton();
            super.getView().getPlayerStatus().getTop().enableBackButton(false);
            GameActionController.setSTATUS(ButtonStatus.NOT_SELECTED);
            super.getView().setStatus(
                    super.getGame().getCurrentPlayer().getName() +
                            ", select the troop you wish to move or attack with");
        }
    }
}
