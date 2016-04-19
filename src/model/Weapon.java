package model;

import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Weapon
{
    private String name;
    private int range;
    private int damage;
    private Direction direction;

    public Weapon(String name, int range, int damage,Direction direction)
    {
        this.name = name;
        this.range = range;
        this.damage = damage;
        this.direction = direction;
    }

    public ArrayList<Position> getWeaponRange(Position location)
    {
        return PossiblePoints.getPossiblePoints(location,range,direction);
    }

    protected int getRange()
    {
        return range;
    }

    public String getName()
    {
        return name;
    }

    public int getDamage()
    {
        return damage;
    }
}
