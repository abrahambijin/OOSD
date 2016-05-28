package Model;

import Interfaces.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Grenade extends WeaponDecoratedWithHead implements Serializable {

    public Grenade(Weapon weapon)
    {
        super(weapon);
    }

    @Override
    public HashMap<Position, ArrayList<Position>> getShootingOptions(
            Position currentLocation)
    {
        HashMap<Position, ArrayList<Position>> possibleOptions =
                super.getShootingOptions(currentLocation);
        HashMap<Position, ArrayList<Position>> newSetOfOptions = new HashMap<>();

        Position head = super.getHead();
        int headXCoordinate = head.getXCoordinate();
        int headYCoordinate = head.getYCoordinate();

        newSetOfOptions.put(head,possibleOptions.get(head));

        if (headXCoordinate == 0)
        {
            Position p1 = new Position(-1,headYCoordinate);
            newSetOfOptions.put(p1,possibleOptions.get(p1));

            p1 = new Position(1,headYCoordinate);
            newSetOfOptions.put(p1,possibleOptions.get(p1));
        }
        else if (headYCoordinate == 0)
        {
            Position p1 = new Position(headXCoordinate,-1);
            newSetOfOptions.put(p1,possibleOptions.get(p1));

            p1 = new Position(headXCoordinate,1);
            newSetOfOptions.put(p1,possibleOptions.get(p1));
        }
        else
        {
            Position p1 = new Position(0,headYCoordinate);
            newSetOfOptions.put(p1,possibleOptions.get(p1));

            p1 = new Position(headXCoordinate,0);
            newSetOfOptions.put(p1,possibleOptions.get(p1));
        }
        return newSetOfOptions;
    }
}
