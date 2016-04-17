package controller;

import model.Game;
import model.Player;
import model.Point;
import view.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class InitialItemPlacingController implements ActionListener
{

    public static int ITEM_INDEX = 0;

    private Point location;
    private Game game;
    private GameGUI view;

    public InitialItemPlacingController(Point location, Game game, GameGUI view)
    {
        this.location = location;
        this.game = game;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Player currentPlayer = game.getCurrentPlayer();

        //System.out.println(location);
        //new CellPosition(location.getXCoordinate(),location.getYCoordinate());


    }
}
