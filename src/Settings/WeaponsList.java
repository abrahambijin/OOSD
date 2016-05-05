package Settings;

import interfaces.Weapon;
import model.BasicWeapon;
import model.Direction;
import model.Grenade;
import model.Sniper;

/**
 * Created by Bijin on 05-May-16.
 */
public final class WeaponsList
{
    public static final Weapon cannon =
            new BasicWeapon("Cannon", 2, Direction.STRAIGHT_LINE, 15);

    public static final Weapon machineGun =
            new BasicWeapon("Machine Gun", 1, Direction.STRAIGHT_LINE, 17);

    public static final Weapon ak47 =
            new BasicWeapon("Ak47", 2, Direction.ANY, 15);

    public static final Weapon pistol =
            new BasicWeapon("Pistol", 1, Direction.ANY, 20);

    public static final Weapon mg17 =
            new BasicWeapon("Mg17", 2, Direction.DIAGONAL, 20);

    public static final Weapon bomb =
            new BasicWeapon("Bomb", 1, Direction.DIAGONAL, 25);

    public static final Weapon sniper =
            new Sniper(new BasicWeapon("Sniper", 3,Direction.CUSTOM, 35));

    public static final Weapon grenade =
            new Grenade(new BasicWeapon("Grenade", 1,Direction.CUSTOM, 30));

    private WeaponsList()
    {
    }
}
