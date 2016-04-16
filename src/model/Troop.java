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

    public Troop(String name,String imageIconPath, int maxNoOfSteps,
                 ArrayList<Weapon> weapons, Direction movingDirection)
    {
        super(name,imageIconPath);
        this.maxNoOfSteps = maxNoOfSteps;
        this.weapons = weapons;
        this.movingDirection = movingDirection;
    }

    public ArrayList<Point> getWeaponRange(int weaponIndex)
    {
        return weapons.get(weaponIndex).getWeaponRange(super.getPosition());
    }

    protected ArrayList<Point> getWeaponRange(int weaponIndex, Point head)
    {
        if(weapons.get(weaponIndex) instanceof WeaponWithHead)
        {
            return ((WeaponWithHead) weapons.get(weaponIndex)).weaponRange
                    (super.getPosition(),head);
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

    public  ArrayList<Point> possibleMovePositions()
    {
        return PossiblePoints.getPossiblePoints(super.getPosition(),
                maxNoOfSteps,movingDirection);
    }

    public void move(Point newPosition)
    {
        super.setPosition(newPosition);
    }

}
