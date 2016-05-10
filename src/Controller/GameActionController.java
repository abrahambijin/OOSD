package Controller;

import Model.Game;
import Model.Position;
import View.GameGUI;

/**
 * Created by Bijin on 10-May-16.
 */
public abstract class GameActionController extends GameController
{
    private static ButtonStatus STATUS = ButtonStatus.NOT_SELECTED;
    private Position location;

    public GameActionController(Game game, GameGUI view, Position location)
    {
        super(game, view);
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
