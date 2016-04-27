package decorator;

import model.Direction;
import model.Position;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 27/04/2016.
 */

// BASE FOR Pistol Ak 47

class HandGun implements FireArm {

    @Override
    public String getName() {
        return "HandGun";
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
        return Direction.ANY;
    }

    @Override
    public ArrayList<Position> getWeaponRange(Position location) {
        return null;
    }
}