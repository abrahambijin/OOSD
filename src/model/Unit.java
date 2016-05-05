package Model;

import Interfaces.Shootable;
import Interfaces.Weapon;
import Utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Unit extends GameItem
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
        if (weapons.get(weaponIndex) instanceof Shootable)
        {
            return ((Shootable) weapons.get(weaponIndex))
                    .getWeaponRange(super.getPosition());
        }
        return null;
    }

//    protected HashMap<Position, ArrayList<Position>> getWeaponRange(
//            int weaponIndex, Position head)
//    {
//        if (weapons.get(weaponIndex) instanceof WeaponWithHead)
//        {
//            return ((WeaponWithHead) weapons.get(weaponIndex))
//                    .getWeaponRange(super.getPosition(), head);
//        }
//        else
//            return getWeaponRange(weaponIndex);
//    }

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

}
