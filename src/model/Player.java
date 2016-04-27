package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Player
{

    private static int noOfPlayers = 0;
    private String name;
    private ArrayList<Troop> troops;
    private PlayerColor color;

    private Player(String name, ArrayList<Troop> troops)
    {
        this(name, troops,new PlayerColor(46,96,234));
    }
    protected Player(String name, ArrayList<Troop> troops, PlayerColor color)
    {
        this.name = name;
        this.color = color;
        this.troops = troops;
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
            Troop tank = new Troop("Tank", 2, new ArrayList<>(Arrays.asList(
                    new Weapon("Cannon", 2, 15, Direction.STRAIGHT_LINE),
                    new Weapon("Machine Gun", 1, 17, Direction.STRAIGHT_LINE))),
                    Direction.STRAIGHT_LINE);
            Tower tower = new Tower();
            return new PlayerOne(name,
                    new ArrayList<>(Arrays.asList(tank, tower)));
        }
        else
        {
            Troop jet = new Troop("Jet", 3, new ArrayList<>(
                    Arrays.asList(new Weapon("Mg17", 2, 20, Direction.DIAGONAL),
                            new Weapon("Bomb", 1, 25, Direction.DIAGONAL))),
                    Direction.DIAGONAL);
            Troop army = new Troop("Army", 1, new ArrayList<>(
                    Arrays.asList(new Weapon("Pistol", 1, 20, Direction.ANY),
                            new Weapon("Ak47", 2, 15, Direction.ANY))), Direction.ANY);
            return new Player(name, new ArrayList<>(Arrays.asList(jet, army)));
        }
    }

    public ArrayList<GameItem> getItems()
    {
        ArrayList<GameItem> items = new ArrayList<>();
        items.addAll(troops);
        return items;
    }

    public PlayerColor getColor() {
        return color;
    }

    public ArrayList<Position> getItemLocations()
    {
        ArrayList<Position> locations = new ArrayList<>();
        for(GameItem item : this.getItems())
            locations.add(item.getPosition());
        return locations;
    }

    public void addExtraWeapon(Weapon weapon){

    }

}
