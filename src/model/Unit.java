package Model;

import Interfaces.Weapon;
import Utility.PossiblePoints;
import Utility.Posture;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Unit extends GameItem implements Cloneable, Serializable
{

    private int maxNoOfSteps;
    private ArrayList<Weapon> weapons;
    private Direction movingDirection;
    private Posture currentPosture;


    public Unit(String name, int maxNoOfSteps, ArrayList<Weapon> weapons,
                Direction movingDirection)
    {
        super(name);
        this.maxNoOfSteps = maxNoOfSteps;
        this.weapons = weapons;
        this.movingDirection = movingDirection;
        this.currentPosture = Posture.NORMAL;
    }

    public HashMap<Position, ArrayList<Position>> getWeaponRange(
            String weaponName)
    {
        return (getWeapon(weaponName)).getShootingOptions(super.getPosition());
    }

    public Weapon getWeapon(String weaponName)
    {
        for (Weapon weapon : weapons)
            if (weapon.getName().equalsIgnoreCase(weaponName))
                return weapon;
        return null;
    }

    public int getMaxNoOfSteps()
    {
        return maxNoOfSteps;
    }

    public ArrayList<Weapon> getWeapons()
    {
        return weapons;
    }

    public HashMap<Position, ArrayList<Position>> possibleMovePositions()
    {
        return PossiblePoints
                .getPossiblePoints(super.getPosition(), maxNoOfSteps,
                        movingDirection);
    }

    @Override
    public void getHit(int damage)
    {
        super.getHit(damage + currentPosture.getValue());
    }

    public int hit(String weaponName)
    {
        return (getWeapon(weaponName).getDamage() + currentPosture.getValue());
    }

    public void move(Position newPosition)
    {
        super.setPosition(newPosition);
    }

    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return clone;
    }

    public void setPosture(Posture posture)
    {
        this.currentPosture = posture;
    }

    public String getCurrentPosture() {
        return currentPosture.toString();
    }
}
