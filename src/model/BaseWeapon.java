package model;

import interfaces.Shootable;
import interfaces.Weapon;
import utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 28/04/2016.
 */

public class BaseWeapon implements Weapon, Shootable
{

    private Direction shootingDirection;

    public BaseWeapon(Direction shootingDirection)
    {
        this.shootingDirection = shootingDirection;
    }

    @Override
    public String getName()
    {
        return "Base Weapon";
    }

    @Override
    public int getRange()
    {
        return 1;
    }

    @Override
    public int getDamage()
    {
        return 10;
    }

    @Override
    public Direction getDirection()
    {
        return shootingDirection;
    }

    @Override
    public HashMap<Position, ArrayList<Position>> getWeaponRange(
            Position location)
    {
        return PossiblePoints
                .getPossiblePoints(location, getRange(), getDirection());
    }
}


