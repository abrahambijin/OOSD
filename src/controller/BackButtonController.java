package controller;

import model.*;
import view.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class BackButtonController implements ActionListener
{
    private Game game;
    private GameGUI view;

    public BackButtonController(Game game, GameGUI view)
    {
        this.game = game;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        CellButtonController.setIsItemSelected(false);
        view.getPlayGround().disableButtons(game.getOccupiedBoardLocation());
        view.getPlayerStatus().getTop().enableBackButton(false);
    }
}