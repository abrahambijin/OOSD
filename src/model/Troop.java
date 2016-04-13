package model;

import interfaces.WeaponWithHead;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Troop extends GameItem
{

    private int steps;
    private ArrayList<Weapon> weapons;
    private Boolean canMoveDiagonally;
    private Boolean canMoveInStraightLine;

    public Troop(String name, int steps,
                 ArrayList<Weapon> weapons, Boolean canMoveDiagonally,
                 Boolean canMoveInStraightLine)
    {
        super(name);
        this.steps = steps;
        this.weapons = weapons;
        this.canMoveDiagonally = canMoveDiagonally;
        this.canMoveInStraightLine = canMoveInStraightLine;
    }

    public ArrayList<Point> getWeaponRange(int weaponIndex)
    {
        return weapons.get(weaponIndex).weaponRange(super.getPosition());
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

    public int getSteps()
    {
        return steps;
    }

    public ArrayList<Weapon> getWeapons()
    {
        return weapons;
    }
}
