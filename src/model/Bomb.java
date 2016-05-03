package model;

import interfaces.Shootable;
import interfaces.Weapon;
import utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 27/04/2016.
 */
public class Bomb extends WeaponDecorator implements Shootable
{

    String overriddenName;

    public Bomb(Weapon decoratedWeapon, String name)
    {
        super(decoratedWeapon);
        this.overriddenName = name;
    }

    @Override
    public String getName()
    {
        return overriddenName;
    }

    @Override
    public int getRange()
    {
        return super.getRange() + 1;
    }

    @Override
    public int getDamage()
    {
        return super.getDamage() + 15;
    }

    @Override
    public Direction getDirection()
    {
        return super.getDirection();
    }

    @Override
    public HashMap<Position, ArrayList<Position>> getWeaponRange(
            Position location)
    {
        return PossiblePoints
                .getPossiblePoints(location, getRange(), getDirection());
    }
}
