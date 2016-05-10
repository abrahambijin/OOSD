package Model;

import Interfaces.Weapon;
import Utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Unit extends GameItem implements Cloneable
{

    private int maxNoOfSteps;
    private ArrayList<Weapon> weapons;
    private Direction movingDirection;


    public Unit(String name, int maxNoOfSteps, ArrayList<Weapon> weapons,
                Direction movingDirection)
    {
        super(name);
        this.maxNoOfSteps = maxNoOfSteps;
        this.weapons = weapons;
        this.movingDirection = movingDirection;
    }

    public HashMap<Position, ArrayList<Position>> getWeaponRange(
            int weaponIndex)
    {
        return (weapons.get(weaponIndex))
                .getShootingOptions(super.getPosition());
    }

    public int getWeaponPower(String weaponName)
    {
        for(Weapon weapon : weapons)
            if(weapon.getName().equalsIgnoreCase(weaponName))
                return weapon.getDamage();
        return -1;
    }

    public int getMaxNoOfSteps()
    {
        return maxNoOfSteps;
    }

    public ArrayList<Weapon> getWeapons()
    {
        return weapons;
    }

    public HashMap<Position, ArrayList<Position>> possibleMovePositions()
    {
        return PossiblePoints
                .getPossiblePoints(super.getPosition(), maxNoOfSteps,
                        movingDirection);
    }

    public void move(Position newPosition)
    {
        super.setPosition(newPosition);
    }

    public void addWeapon(Weapon weapon)
    {
        this.weapons.add(weapon);
    }

    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return clone;
    }

}
