package model;

import interfaces.Weapon;

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
        this(name, troops, new PlayerColor(46, 96, 234));
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
        BaseWeapon baseWeapon = new BaseWeapon(Direction.STRAIGHT_LINE);

        if (noOfPlayers == 0)
        {
            Troop tank = new Troop("Tank", 2, new ArrayList<>(Arrays.asList(
                    new Cannon(baseWeapon, "Cannon"),
                    new MachineGun(baseWeapon, "Machine Gun"))), Direction.STRAIGHT_LINE);
            Tower tower = new Tower();
            return new PlayerOne(name,
                    new ArrayList<>(Arrays.asList(tank, tower)));
        }
        else
        {
            baseWeapon = new BaseWeapon(Direction.ANY);

            Troop army = new Troop("Army", 1, new ArrayList<>(
                    Arrays.asList(new Pistol(baseWeapon, "Pistol"), new Ak47(baseWeapon, "AK 47"))), Direction.ANY);

            baseWeapon = new BaseWeapon(Direction.DIAGONAL);

            Troop jet = new Troop("Jet", 3, new ArrayList<>(
                    Arrays.asList(new Mg17(baseWeapon, "MG 17"),
                            new Bomb(baseWeapon, "Bomb"))), Direction.DIAGONAL);

            return new Player(name, new ArrayList<>(Arrays.asList(jet, army)));
        }
    }

    public ArrayList<GameItem> getItems()
    {
        ArrayList<GameItem> items = new ArrayList<>();
        items.addAll(troops);
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
