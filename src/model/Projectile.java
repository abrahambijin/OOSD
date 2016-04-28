package model;

import interfaces.Shootable;
import interfaces.Weapon;
import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/04/2016.
 */

// BASE FOR Mg 17 BOMB

class Projectile implements Weapon, Shootable {

    @Override
    public String getName() {
        return "Projectile";
    }

    @Override
    public int getRange() {
        return 1;
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public Direction getDirection() {
        return Direction.DIAGONAL;
    }

    @Override
    public ArrayList<Position> getWeaponRange(Position location) {
        return PossiblePoints.getPossiblePoints(location,getRange(), getDirection());
    }
}