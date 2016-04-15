package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Bijin on 12-Apr-16.
 */
public class WeaponObjects
{
    Weapon Ak47 = new Weapon("Ak47",2,15,Direction.ANY);
    Weapon bomb = new Weapon("Bomb",1,25,Direction.DIAGONAL);
    Weapon cannon = new Weapon("Cannon",2,15,Direction.STRAIGHT_LINE);
    Weapon machineGun = new Weapon("Machine Gun",1,17,Direction.STRAIGHT_LINE);
    Weapon Mg17 = new Weapon("Mg17",2,20,Direction.DIAGONAL);
    Weapon pistol = new Weapon("Pistol",1,20,Direction.ANY);

    Troop jet = new Troop("Jet", 3, new ArrayList<>(
            Arrays.asList(Mg17, bomb)), Direction.DIAGONAL);
    Troop army = new Troop("Army", 1, new ArrayList<>(
            Arrays.asList(pistol, Ak47)), Direction.ANY);
    Troop tank = new Troop("Tank", 2, new ArrayList<>(
            Arrays.asList(cannon, machineGun)),
            Direction.STRAIGHT_LINE);
}
