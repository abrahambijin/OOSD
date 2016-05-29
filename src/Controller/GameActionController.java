package Controller;

import Utility.Position;
import View.GameGUI;

import java.awt.event.ActionListener;

/**
 * Created by Bijin on 10-May-16.
 */
public abstract class GameActionController extends GameController implements
        ActionListener
{
    private Position location;

    public GameActionController(GameGUI view, Position location)
    {
        super(view);
        this.location = location;
    }

    public Position getLocation()
    {
        return location;
    }
}
