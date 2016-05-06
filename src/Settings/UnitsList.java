package Settings;


import Model.Direction;
import Model.Tower;
import Model.Unit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Bijin on 05-May-16.
 */
public final class UnitsList
{
    public static Unit getTank()
    {
        return new Unit("Tank", 2, new ArrayList<>(
                Arrays.asList(WeaponsList.cannon, WeaponsList.machineGun)),
                Direction.STRAIGHT_LINE);
    }

    public static final Tower tower = new Tower(new ArrayList<>(
            Arrays.asList(WeaponsList.sniper, WeaponsList.grenade)));

    public static Unit getArmy()
    {
        return new Unit("Army", 1, new ArrayList<>(
                Arrays.asList(WeaponsList.pistol, WeaponsList.ak47)),
                Direction.ANY);
    }

    public static final Unit jet = new Unit("Jet", 3,
            new ArrayList<>(Arrays.asList(WeaponsList.mg17, WeaponsList.bomb)),
            Direction.DIAGONAL);

    private UnitsList()
    {
    }
}
