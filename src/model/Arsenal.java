package model;

import interfaces.Weapon;

/**
 * Created by mitulmanish on 23/04/2016.
 */
public class Arsenal extends GameItem
{

    private Weapon weapon;

    public Arsenal(String name, Weapon weapon)
    {
        super(name);
        this.weapon = weapon;
    }

    public Weapon getBonusWeapon()
    {
        return weapon;
    }
}
