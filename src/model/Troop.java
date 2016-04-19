package model;

import interfaces.WeaponWithHead;
import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Troop extends GameItem
{

    private int maxNoOfSteps;
    private ArrayList<Weapon> weapons;
    private Direction movingDirection;

    public Troop(String name, int maxNoOfSteps, ArrayList<Weapon> weapons,
                 Direction movingDirection)
    {
        super(name);
        this.maxNoOfSteps = maxNoOfSteps;
        this.weapons = weapons;
        this.movingDirection = movingDirection;
    }

    public ArrayList<Position> getWeaponRange(int weaponIndex)
    {
        return weapons.get(weaponIndex).getWeaponRange(super.getPosition());
    }

    protected ArrayList<Position> getWeaponRange(int weaponIndex, Position head)
    {
        if (weapons.get(weaponIndex) instanceof WeaponWithHead)
        {
            return ((WeaponWithHead) weapons.get(weaponIndex))
                    .weaponRange(super.getPosition(), head);
        }
        else
            return getWeaponRange(weaponIndex);
    }

    public int getMaxNoOfSteps()
    {
        return maxNoOfSteps;
    }

    public ArrayList<Weapon> getWeapons()
    {
        return weapons;
    }

    public ArrayList<Position> possibleMovePositions()
    {
        return PossiblePoints
                .getPossiblePoints(super.getPosition(), maxNoOfSteps,
                        movingDirection);
    }

    public void move(Position newPosition)
    {
        super.setPosition(newPosition);
    }

}
