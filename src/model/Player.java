package Model;

import Settings.UnitsList;
import Interfaces.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Player
{

    private static int noOfPlayers = 0;
    private String name;
    private ArrayList<Unit> units;
    private PlayerColor color;

    private Player(String name, ArrayList<Unit> units)
    {
        this(name, units, new PlayerColor(46, 96, 234));
    }

    protected Player(String name, ArrayList<Unit> units, PlayerColor color)
    {
        this.name = name;
        this.color = color;
        this.units = units;
        noOfPlayers++;
    }

    public String getName()
    {
        return name;
    }

    public static Player playerFactory(String name)
    {
        if (noOfPlayers == 0)
        {
            return new PlayerOne(name, new ArrayList<>(
                    Arrays.asList(UnitsList.tank, UnitsList.tower)));
        }
        else
        {
            return new Player(name, new ArrayList<>(
                    Arrays.asList(UnitsList.jet, UnitsList.army)));
        }
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

    public void addExtraWeapon(Weapon weapon)
    {

    }

}
