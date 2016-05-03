package model;

import interfaces.Weapon;
import interfaces.WeaponWithHead;
import utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Grenade implements WeaponWithHead, Weapon
{

    @Override
    public String getName()
    {
        return "Grenade";
    }

    @Override
    public int getRange()
    {
        return 1;
    }

    @Override
    public int getDamage()
    {
        return 30;
    }

    @Override
    public Direction getDirection()
    {
        return Direction.CUSTOM;
    }


    @Override
    public HashMap<Position, ArrayList<Position>> getWeaponRange(Position location, Position head)
    {
        HashMap<Position, ArrayList<Position>> possibleOptions = PossiblePoints
                .getPossiblePoints(location, getRange(), getDirection());
        HashMap<Position, ArrayList<Position>> newSetOfOptions =
                new HashMap<>();

        int headXCoordinate = head.getXCoordinate();
        int headYCoordinate = head.getYCoordinate();

        newSetOfOptions.put(head, possibleOptions.get(head));

        if (headXCoordinate == 0)
        {
            Position p1 = new Position(-1, headYCoordinate);
            newSetOfOptions.put(p1, possibleOptions.get(p1));

            p1 = new Position(1, headYCoordinate);
            newSetOfOptions.put(p1, possibleOptions.get(p1));
        }
        else if (headYCoordinate == 0)
        {
            Position p1 = new Position(headXCoordinate, -1);
            newSetOfOptions.put(p1, possibleOptions.get(p1));

            p1 = new Position(headXCoordinate, 1);
            newSetOfOptions.put(p1, possibleOptions.get(p1));
        }
        else
        {
            Position p1 = new Position(0, headYCoordinate);
            newSetOfOptions.put(p1, possibleOptions.get(p1));

            p1 = new Position(headXCoordinate, 0);
            newSetOfOptions.put(p1, possibleOptions.get(p1));
        }
        return newSetOfOptions;
    }
}
