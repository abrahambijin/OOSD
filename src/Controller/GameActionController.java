package Controller;

import Model.Game;
import Model.Position;
import View.GameGUI;

import java.awt.event.ActionListener;

/**
 * Created by Bijin on 10-May-16.
 */
public abstract class GameActionController extends GameController implements
        ActionListener
{
    private static ButtonStatus STATUS = ButtonStatus.NOT_SELECTED;
    private Position location;

    public GameActionController(GameGUI view, Position location)
    {
        super(view);
        this.location = location;
    }

    public static void setSTATUS(ButtonStatus STATUS)
    {
        GameActionController.STATUS = STATUS;
    }

    public static ButtonStatus getSTATUS()
    {
        return STATUS;
    }

    public Position getLocation()
    {
        return location;
    }
}
