package model;
import interfaces.Shootable;
import interfaces.Weapon;
import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/04/2016.
 */

// make this class a base class for staright line shooting weapons

// BASE FOR CANNON , MACHINE GUN

class Rifle implements Weapon, Shootable {

    @Override
    public String getName() {
        return "Rifle";
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
        return Direction.STRAIGHT_LINE;
    }

    @Override
    public ArrayList<Position> getWeaponRange(Position location) {
        return PossiblePoints.getPossiblePoints(location,getRange(), getDirection());
    }
}
