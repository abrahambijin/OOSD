package Settings;


import Model.Direction;
import Model.Tower;
import Model.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Bijin on 05-May-16.
 */
public final class UnitsList
{
    private static HashMap<String,Unit> unitsList = new HashMap<>();

    public static void generateUnits()
    {
        Unit tank = new Unit("Tank", 2, new ArrayList<>(
                Arrays.asList(WeaponsList.cannon, WeaponsList.machineGun)),
                Direction.STRAIGHT_LINE);

        Tower tower = new Tower(new ArrayList<>(
                Arrays.asList(WeaponsList.sniper, WeaponsList.grenade)));

        Unit army = new Unit("Army", 1, new ArrayList<>(
                Arrays.asList(WeaponsList.pistol, WeaponsList.ak47)),
                Direction.ANY);

        Unit jet = new Unit("Jet", 3,
                new ArrayList<>(Arrays.asList(WeaponsList.mg17, WeaponsList.bomb)),
                Direction.DIAGONAL);

        unitsList.put(tower.getName(),tower);
        unitsList.put(tank.getName(),tank);
        unitsList.put(jet.getName(),jet);
        unitsList.put(army.getName(),army);
    }

    public static Unit getUnit(String unitName)
    {
        return (Unit) unitsList.get(unitName).clone();
    }

}
