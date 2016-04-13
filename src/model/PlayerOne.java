package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 11/04/2016.
 */
public class PlayerOne extends Player {

    private GameItem base;

    public PlayerOne(String name, ArrayList<Troop> troops) {
        super(name, troops);
        this.base = new GameItem("Base",new Point(0, 0), 500);
    }

    public ArrayList<GameItem> getItems()
    {
        ArrayList<GameItem> items = super.getItems();
        items.add(0,base);
        return items;
    }
}
