package Model;

import Interfaces.Weapon;
import Utility.Position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijin on 28-Apr-16.
 */
public class Sniper extends WeaponDecoratedWithHead implements Serializable
{
    public Sniper(Weapon weapon)
    {
        super(weapon);
    }

    @Override
    public HashMap<Position, ArrayList<Position>> getShootingOptions(
            Position currentLocation)
    {
        HashMap<Position, ArrayList<Position>> newSetOfOptions =
                new HashMap<>();

        newSetOfOptions.put(super.getHead(),
                super.getShootingOptions(currentLocation).get(super.getHead()));

        return newSetOfOptions;
    }
}
