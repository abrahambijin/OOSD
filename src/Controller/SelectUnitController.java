package Controller;

import Model.*;
import View.GameGUI;

import java.awt.event.ActionEvent;

/**
 * Created by Bijin on 11-May-16.
 */
public class SelectUnitController extends GameActionController
{
    public SelectUnitController(Game game, GameGUI view, Position location)
    {
        super(game, view, location);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (GameActionController.getSTATUS() == ButtonStatus.NOT_SELECTED)
        {
            GameItem item = super.getGame().getItem(super.getLocation());
            if (item != null)
            {
                Boolean pass = super.getGame()
                        .isTroopOfCurrentPlayer(super.getLocation()) &&
                        !(item instanceof Base);
                super.getView().getPlayerStatus().setItem(item, pass);
            }
            super.getView().setStatus(
                    super.getGame().getCurrentPlayer().getName() +
                            ", would you like to move or attack?");
        }
    }
}
