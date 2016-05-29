package Controller;

import Memento.CareTaker;
import Memento.Originator;
import Model.Game;
import View.GameGUI;


/**
 * Created by Bijin on 10-May-16.
 */
public abstract class GameController
{
    private static Game game;
    private static CareTaker careTaker;
    private static Originator originator;

    private GameGUI view;

    public GameController(GameGUI view)
    {
        this.view = view;
    }

    public static void setController(Game game)
    {
        GameController.game = game;
        GameController.careTaker = new CareTaker();
        GameController.originator = new Originator();
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
        careTaker.store(originator.saveMemento(game));
    }

    public void undo(int undoStage)
    {
        Game newGame = originator.restoreMemento(careTaker.load(undoStage));
        if (newGame != null)
            GameController.game = newGame;
    }
}
