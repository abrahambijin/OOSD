package Controller;

import Memento.CareTaker;
import Model.Game;
import View.GameGUI;


/**
 * Created by Bijin on 10-May-16.
 */
public abstract class GameController
{
    private static Game game;
    private static CareTaker careTaker;
    private GameGUI view;

    public GameController(GameGUI view)
    {
        this.view = view;
    }

    public static void setController(Game game)
    {
        GameController.game = game;
        GameController.careTaker = new CareTaker();
    }

    public Game getGame()
    {
        return game;
    }

    public GameGUI getView()
    {
        return view;
    }

    public void saveGame()
    {
        careTaker.store(game);
    }

    public void undo()
    {
        Game newGame = careTaker.load(1);
        if (newGame != null)
            GameController.game = newGame;
    }
}
