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
    private String name;
    private ArrayList<GameItem> units;
    private PlayerColor color;
    private boolean isPlayerOne;

    private Player(String name, ArrayList<GameItem> units, PlayerColor color, boolean isPlayerOne)
    {
        this.name = name;
        this.color = color;
        this.units = units;
        this.isPlayerOne = isPlayerOne;
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
        AbstractFactory playerFactory = PlayerComponentFactory.getPlayerPropertyFactory();


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

    public void addExtraWeapon(Weapon weapon)
    {

    }

}
