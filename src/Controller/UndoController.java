package Controller;

import Model.Game;
import Undo.SaveGameState;
import View.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bijin on 10-May-16.
 */
public class UndoController extends GameController
{
    public UndoController(Game game, GameGUI view)
    {
        super(game, view);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        super.undo();
    }
}
