package controller;

import model.Base;
import model.Game;
import model.GameItem;
import model.Point;
import view.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class CellButtonController implements ActionListener
{
    private static boolean isItemSelected = false;
    private Point location;
    private Game game;
    private GameGUI view;

    public CellButtonController(Point location, Game game, GameGUI view)
    {
        this.location = location;
        this.game = game;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        GameItem item = game.getItem(location);
        if (item != null)
        {
            if (isItemSelected)
            {
            }
            else
            {
                Boolean pass = game.isTroopOfCurrentPlayer(location) &&
                        !(item instanceof Base);
                view.getPlayerStatus().getTop().setMoveEnabled(pass);
                view.getPlayerStatus().getTop().setValues(item);
            }
        }
    }
}
