package model;

import exceptions.ObjectAlreadyExistException;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 11/04/2016.
 */
public class PlayerOne extends Player {

    private GameItem base;

    public PlayerOne(String name, ArrayList<Troop> troops) {
        super(name, troops,new PlayerColor(255,0,0));
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
        items.add(0,base);
        return items;
    }
}