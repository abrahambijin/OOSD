package decorator;

import model.Direction;
import model.Position;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/04/2016.
 */

// make this class a base class for staright line shooting weapons

class StraightLineShootingWeapon implements FireArm {

    @Override
    public String getName() {
        return "I m a base straight line shooting thing";
    }

    @Override
    public int getRange() {
        return 0;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public Direction getDirection() {
        return Direction.STRAIGHT_LINE;
    }

    @Override
    public ArrayList<Position> getWeaponRange(Position location) {
        return null;
    }
}
