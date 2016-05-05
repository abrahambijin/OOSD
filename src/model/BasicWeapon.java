package model;

import interfaces.Weapon;
import utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijin on 28-Apr-16.
 */
public class BasicWeapon implements Weapon
{
    private String weaponName;
    private int range;
    private Direction shootingDirection;
    private int damage;

    public BasicWeapon(String weaponName, int range,
                       Direction shootingDirection, int damage)
    {
        this.weaponName = weaponName;
        this.range = range;
        this.shootingDirection = shootingDirection;
        this.damage = damage;
    }


    @Override
    public int getDamage()
    {
        return damage;
    }

    @Override
    public HashMap<Position, ArrayList<Position>> getShootingOptions(Position currentLocation)
    {
        return PossiblePoints.getPossiblePoints(currentLocation,range,
                shootingDirection);
    }

    @Override
    public String getName()
    {
        return weaponName;
    }
}
