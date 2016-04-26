package decorator;

import model.Direction;

/**
 * Created by mitulmanish on 26/04/2016.
 */
class StraightLineShootingWeapon implements FireArm {

    @Override
    public String getName() {
        return "I m a base staright line shooting thing";
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
}
