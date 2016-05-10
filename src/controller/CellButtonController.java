package Controller;

import Model.*;
import View.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class CellButtonController extends GameController
{
    private static ButtonStatus status = ButtonStatus.NOT_SELECTED;
    private Position location;

    public CellButtonController(Game game, GameGUI view, Position location)
    {
        super(game, view);
        this.location = location;
    }

    public static void setStatus(ButtonStatus status)
    {
        CellButtonController.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (status == ButtonStatus.SELECTED_TO_MOVE)
            moveItem();

        else if (status == ButtonStatus.NOT_SELECTED)
            selectItem();
    }

    private void selectItem()
    {
        GameItem item = super.getGame().getItem(location);
        if (item != null)
        {
            Boolean pass = super.getGame().isTroopOfCurrentPlayer(location) &&
                    !(item instanceof Base);
            super.getView().getPlayerStatus().setItem(item, pass);
        }
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", would you like to move or attack?");
    }

    private void moveItem()
    {
        Position currentLocation =
                super.getView().getPlayerStatus().getItemLocation();
        GameItem item = super.getGame().getItem(currentLocation);

        boolean success = super.getGame().move(currentLocation, location);

        if (success)
        {
            if (item instanceof Tower)
            {
                super.getView().getPlayGround().setButtonImage(currentLocation,
                        item.getImageIconPath());
            }

            else
            {
                super.getView().getPlayGround()
                        .moveItem(currentLocation, location,
                                item.getImageIconPath());
            }
            super.getView().getPlayerStatus().getBottom().setVisible(false);
            super.getGame().nextPlayer();
            super.getView().getPlayGround()
                    .disableButtons(super.getGame().getOccupiedBoardLocation(),
                            null);
            super.getView().getPlayerStatus()
                    .updatePage(super.getGame().getCurrentPlayer());
        }
        super.getView().getPlayerStatus().getTop().enableBackButton(false);
        GameActionController.setSTATUS(ButtonStatus.NOT_SELECTED);
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", select the troop you wish to move or attack with");
    }
}
