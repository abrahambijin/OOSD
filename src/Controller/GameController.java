package Controller;

import Model.Game;
import View.GameGUI;

import java.awt.event.ActionListener;

/**
 * Created by Bijin on 10-May-16.
 */
public abstract class GameController implements ActionListener
{
    private Game game;
    private GameGUI view;

    public GameController(Game game, GameGUI view)
    {
        this.game = game;
        this.view = view;
    }

    public Game getGame()
    {
        return game;
    }

    public GameGUI getView()
    {
        return view;
    }
}
