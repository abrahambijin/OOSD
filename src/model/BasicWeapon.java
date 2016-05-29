package Model;

import Interfaces.Weapon;
import Utility.Direction;
import Utility.Position;
import Utility.PossiblePoints;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijin on 28-Apr-16.
 */
public class BasicWeapon implements Weapon, Serializable
{
    private String weaponName;
    private int range;
    private Direction shootingDirection;
    private int damage;
    private String weaponIcon;

    public BasicWeapon(String weaponName, int range,
                       Direction shootingDirection, int damage)
    {
        this.weaponName = weaponName;
        this.range = range;
        this.shootingDirection = shootingDirection;
        this.damage = damage;
        this.weaponIcon = "Images/Weapons/"+ weaponName +".png";
    }


    @Override
    public int getDamage()
    {
        return damage;
    }

    @Override
    public String getImage(){return weaponIcon;}

    @Override
    public HashMap<Position, ArrayList<Position>> getShootingOptions(Position currentLocation)
    {
        return PossiblePoints.getPossiblePoints(currentLocation,range,
                shootingDirection);
    }

    @Override
    public String getName()
    {
        return weaponName;
    }
}
