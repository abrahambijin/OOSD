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

    public Player(String name, ArrayList<Troop> troops)
    {
        this.name = name;
        this.troops = troops;
        noOfPlayers++;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Troop> getTroops()
    {
        return troops;
    }

    public static Player playerFactory(String name)
    {
        if (noOfPlayers == 0)
        {
            Troop tank = new Troop("Tank", 2, new ArrayList<>(
                    Arrays.asList(new Weapon("Cannon", 2, 15, false, true),
                            new Weapon("Machine Gun", 1, 17, false, true))),
                    false, true);
            Tower tower = new Tower();
            return new PlayerOne(name,
                    new ArrayList<>(Arrays.asList(tank, tower)));
        }
        else
        {
            Troop jet = new Troop("Jet", 3, new ArrayList<>(
                    Arrays.asList(new Weapon("Mg17", 2, 20, true, false),
                            new Weapon("Bomb", 1, 25, true, false))), true,
                    false);
            Troop army = new Troop("Army", 1, new ArrayList<>(
                    Arrays.asList(new Weapon("Pistol", 1, 20, true, true),
                            new Weapon("Ak47", 2, 15, true, true))), true,
                    true);
            return new Player(name, new ArrayList<>(Arrays.asList(jet, army)));
        }
    }

    public ArrayList<GameItem> getItems()
    {
        ArrayList<GameItem> items = new ArrayList<>();
        items.addAll(troops);
        return items;
    }
}
