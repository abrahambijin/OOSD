package Controller;

import Model.Game;
import Undo.SaveGameState;
import View.GameGUI;

import java.awt.event.ActionListener;

/**
 * Created by Bijin on 10-May-16.
 */
public abstract class GameController implements ActionListener
{
    private Game game;
    private GameGUI view;
    private SaveGameState saveGameState;

    public GameController(Game game, GameGUI view)
    {
        this.game = game;
        this.view = view;
        this.saveGameState = new SaveGameState();
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
        this.game = game;
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
