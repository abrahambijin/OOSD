package Model;

import Interfaces.Weapon;
import Utility.Position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijin on 28-Apr-16.
 */
public abstract class WeaponDecoratedWithHead implements Weapon, Serializable
{

    private Weapon weapon;
    private Position head;

    public WeaponDecoratedWithHead(Weapon weapon)
    {
        this.weapon = weapon;
        this.head = null;
    }

    @Override
    public int getDamage()
    {
        return weapon.getDamage();
    }

    @Override
    public String getImage() {return weapon.getImage();}
    @Override
    public HashMap<Position, ArrayList<Position>> getShootingOptions(Position currentLocation)
    {
        return weapon.getShootingOptions(currentLocation);
    }

    @Override
    public String getName()
    {
        return weapon.getName();
    }

    public void updateHead(Position head)
    {
        this.head = head;
    }

    protected Position getHead()
    {
        return head;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }
}
