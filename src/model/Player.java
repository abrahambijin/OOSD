package Model;

import Factory.PlayerPropertiesFactory;
import Interfaces.AbstractPlayerPropertiesFactory;
import Interfaces.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Player implements Serializable, Observer
{
    private String name;
    private ArrayList<GameItem> units;
    private PlayerColor color;
    private boolean isPlayerOne;
    private boolean isAlive;
    private boolean undoCalled;

    private Player(String name, ArrayList<GameItem> units, PlayerColor color, boolean isPlayerOne)
    {
        this.name = name;
        this.color = color;
        this.units = units;
        this.isPlayerOne = isPlayerOne;
        this.isAlive = true;
        this.undoCalled = false;

        for (GameItem unit : units)
            unit.addObserver(this);
    }

    public boolean isPlayerOne() {
        return isPlayerOne;
    }

    public String getName()
    {
        return name;
    }

    public static Player playerFactory(String name, int noOfUnits)
    {
        AbstractPlayerPropertiesFactory playerFactory = PlayerPropertiesFactory.getPlayerPropertyFactory();


        return new Player(name, playerFactory.getPlayerItem(noOfUnits),
                    playerFactory.getColor(), playerFactory.isPlayerOne());
    }

    public ArrayList<GameItem> getItems()
    {
        ArrayList<GameItem> items = new ArrayList<>();
        items.addAll(units);
        return items;
    }

    public PlayerColor getColor()
    {
        return color;
    }

    public ArrayList<Position> getItemLocations()
    {
        ArrayList<Position> locations = new ArrayList<>();
        for (GameItem item : this.getItems())
            locations.add(item.getPosition());
        return locations;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public boolean isUndoCalled()
    {
        return undoCalled;
    }

    public void undoIsCalled()
    {
        this.undoCalled = true;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof GameItem)
        {
            if(units.contains(o))
            {
                units.remove(o);
                int count = isPlayerOne? 1:0;

                if (units.size()<=count)
                    isAlive = false;
            }
        }
    }
}
