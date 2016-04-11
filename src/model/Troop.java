package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Troop extends GameItem
{

    private int steps;
    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;


    public Troop(String name, Point position, int steps, Weapon primaryWeapon,
                 Weapon secondaryWeapon)
    {
        super(name,position);
        this.steps = steps;
        this.primaryWeapon = primaryWeapon;
        this.secondaryWeapon = secondaryWeapon;
    }


    public ArrayList<Point> primaryWeaponRange()
    {
        return primaryWeapon.weaponRange(super.getPosition());
    }

    public ArrayList<Point> secondaryWeaponRange()
    {
        return secondaryWeapon.weaponRange(super.getPosition());
    }

    public int getSteps()
    {
        return steps;
    }

    public Weapon getPrimaryWeapon()
    {
        return primaryWeapon;
    }

    public Weapon getSecondaryWeapon()
    {
        return secondaryWeapon;
    }
}
