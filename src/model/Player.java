package Model;

import Factory.PlayerPropertiesFactory;
import Interfaces.AbstractPlayerPropertiesFactory;
import Interfaces.Weapon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Player implements Serializable
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

    public void updateItemList()
    {
        int index = -1;
        for (int i = 0; i<units.size(); i++)
            if (!units.get(i).isActive())
            {
                index = i;
                break;
            }

        if(index>=0)
            units.remove(index);

        int count = isPlayerOne? 1:0;

        if (units.size()<=count)
            isAlive = false;
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
}
