package controller;

import model.Base;
import model.Game;
import model.GameItem;
import model.Position;
import view.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class MoveButtonController implements ActionListener
{
    private Game game;
    private GameGUI view;

    public MoveButtonController(Game game, GameGUI view)
    {
        this.game = game;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        CellButtonController.setIsItemSelected(true);
        GameItem item = game.getItem(view.getPlayerStatus().getItemLocation());
        view.getPlayGround().disableButtons(game.getPossibleMovePoints(item));
        view.getPlayerStatus().getTop().enableBackButton(true);
        view.setStatus(game.getCurrentPlayer().getName() +
                ", where would you like to move " + item.getName() + "to?");
    }
}
