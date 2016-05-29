package Controller;

import Model.*;
import Utility.Position;
import View.GameGUI;

import java.awt.event.ActionEvent;

/**
 * Created by Bijin on 11-May-16.
 */
public class SelectUnitController extends GameActionController
{
    public SelectUnitController(GameGUI view, Position location)
    {
        super(view, location);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        GameItem item = super.getGame().getItem(super.getLocation());
        if (item != null)
        {
            Boolean pass = super.getGame()
                    .isUnitOfCurrentPlayer(super.getLocation()) &&
                    !(item instanceof Base);

            boolean canUndo =
                    pass && !super.getGame().getCurrentPlayer().isUndoCalled();

            super.getView().getPlayerStatus().setItem(item, pass, canUndo);
        }
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", would you like to move or attack?");

    }
}
