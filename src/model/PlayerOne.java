package Model;

import Exceptions.ObjectAlreadyExistException;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 11/04/2016.
 */
public class PlayerOne extends Player
{

    private Base base;

    public PlayerOne(String name, ArrayList<Unit> units)
    {
        super(name, units, new PlayerColor(255, 50, 0));
        try
        {
            this.base = Base.baseFactory();
        }
        catch (ObjectAlreadyExistException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<GameItem> getItems()
    {
        ArrayList<GameItem> items = super.getItems();
        items.add(0, base);
        return items;
    }
}
