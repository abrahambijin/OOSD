package model;

/**
 * Created by Bijin on 12-Apr-16.
 */
public class WeaponObjects
{
    Weapon Ak47 = new Weapon("Ak47",2,15,true,true);
    Weapon bomb = new Weapon("Bomb",1,25,true,false);
    Weapon cannon = new Weapon("Cannon",2,15,false,true);
    Weapon machineGun = new Weapon("Machine Gun",1,17,false,true);
    Weapon Mg17 = new Weapon("Mg17",2,20,true,false);
    Weapon pistol = new Weapon("Pistol",1,20,true,true);

    Troop army = new Troop("Army",new Point(6,6),1, new Weapon("Pistol", 1,
            20, true, true),
            new Weapon("Ak47", 2, 15, true, true));
    Troop jet = new Troop("Jet",new Point(0, 0), 3,
            new Weapon("Bomb", 1, 25, true, false),
            new Weapon("Mg17", 2, 20, true, false));
    Troop tank = new Troop("Tank",new Point(6, 6), 2,
            new Weapon("Cannon", 2, 15, false, true),
            new Weapon("Machine Gun", 1, 17, false, true));
}
