package Controller;

import Model.Game;
import Model.GameItem;
import Model.Position;
import Model.Tower;
import View.GameGUI;

import java.awt.event.ActionEvent;

/**
 * Created by Bijin on 11-May-16.
 */
public class MoveUnitController extends GameActionController
{
    public MoveUnitController(Game game, GameGUI view, Position location)
    {
        super(game, view, location);
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
                super.getView().getPlayerStatus().getBottom().setVisible(false);
                super.getGame().nextPlayer();
                super.getView().getPlayGround().disableButtons(
                        super.getGame().getOccupiedBoardLocation(), null);
                super.getView().getPlayerStatus()
                        .updatePage(super.getGame().getCurrentPlayer());
            }
            super.getView().getPlayerStatus().getTop().enableBackButton(false);
            GameActionController.setSTATUS(ButtonStatus.NOT_SELECTED);
            super.getView().setStatus(
                    super.getGame().getCurrentPlayer().getName() +
                            ", select the troop you wish to move or attack with");
        }
    }
}
