package model;

import interfaces.Weapon;
import interfaces.WeaponWithHead;
import utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Sniper implements Weapon, WeaponWithHead{

    @Override
    public String getName() {
        return "Sniper";
    }

    @Override
    public int getRange() {
        return 3;
    }

    @Override
    public int getDamage() {
        return 35;
    }

    @Override
    public Direction getDirection() {
        return Direction.CUSTOM;
    }

    @Override
    public HashMap<Position, ArrayList<Position>> getWeaponRange(
            Position location, Position head)
    {
        HashMap<Position, ArrayList<Position>> newSetOfOptions =
                new HashMap<>();

        newSetOfOptions.put(head, PossiblePoints.getPossiblePoints
                (location,getRange(),getDirection()).get(head));

        return newSetOfOptions;
    }
}
