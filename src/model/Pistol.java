package model;
import interfaces.Shootable;
import interfaces.Weapon;
import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 27/04/2016.
 */
public class Pistol extends WeaponDecorator implements Shootable {

    String overriddenName;

    public Pistol(Weapon decoratedWeapon, String name) {
        super(decoratedWeapon);
        this.overriddenName = name;
    }

    @Override
    public String getName() {
        return overriddenName;
    }

    @Override
    public int getRange() {
        return super.getRange();
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 10;
    }

    @Override
    public Direction getDirection() {
        return super.getDirection();
    }

    @Override
    public ArrayList<Position> getWeaponRange(Position location) {
        return PossiblePoints.getPossiblePoints(location,getRange(), getDirection());
    }
}
