package Controller;

import Memento.CareTaker;
import Model.Game;
import Undo.SaveGameState;
import View.GameGUI;

import java.awt.event.ActionListener;

/**
 * Created by Bijin on 10-May-16.
 */
public abstract class GameController
{
    private static Game game;
    private static CareTaker careTaker;
    private GameGUI view;
    private SaveGameState saveGameState;

    public GameController(GameGUI view)
    {
        this.view = view;
        this.saveGameState = new SaveGameState();
    }

    public static void setControler(Game game)
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

    public void setGame(Game game) {
        GameController.game = game;
    }

    public void setView(GameGUI view) {
        this.view = view;
    }

    public void saveGame()
    {
        saveGameState.saveGame(this);
    }

    public void undo()
    {
        saveGameState.loadGame(this,1);
    }
}
