package controller;

import model.*;
import view.GameGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class CellButtonController implements ActionListener
{
    private static boolean isItemSelected = false;
    private Position location;
    private Game game;
    private GameGUI view;

    public CellButtonController(Position location, Game game, GameGUI view)
    {
        this.location = location;
        this.game = game;
        this.view = view;
    }

    public static void setIsItemSelected(boolean isItemSelected)
    {
        CellButtonController.isItemSelected = isItemSelected;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (isItemSelected)
            moveItem();

        else
            selectItem();
    }

    private void selectItem()
    {
        GameItem item = game.getItem(location);
        if (item != null)
        {
            Boolean pass = game.isTroopOfCurrentPlayer(location) &&
                    !(item instanceof Base);
            view.getPlayerStatus().setItem(item, pass);
        }
        view.setStatus(
                game.getCurrentPlayer().getName() + ", would you like to move" +
                        " or attack?");
    }

    private void moveItem()
    {
        Position currentLocation = view.getPlayerStatus().getItemLocation();
        GameItem item = game.getItem(currentLocation);

        boolean success = game.move(currentLocation, location);

        if (success)
        {
            if (item instanceof Tower)
            {
                view.getPlayGround().setButtonImage(currentLocation,
                        item.getImageIconPath());
            }

            else
            {
                view.getPlayGround().moveItem(currentLocation, location,
                        item.getImageIconPath());
            }

            game.nextPlayer();
            view.getPlayGround()
                    .disableButtons(game.getOccupiedBoardLocation(), null);
            view.getPlayerStatus().updatePage(game.getCurrentPlayer());
        }
        view.getPlayerStatus().getTop().enableBackButton(false);
        isItemSelected = false;
        view.setStatus(
                game.getCurrentPlayer().getName() + ", select the troop you " +
                        "wish to move or attack with");
    }
}
