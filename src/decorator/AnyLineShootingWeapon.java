package decorator;

import model.Direction;

/**
 * Created by mitulmanish on 27/04/2016.
 */
class AnyLineShootingWeapon implements FireArm {

    @Override
    public String getName() {
        return "I m a base omni directional shooting thing";
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
        return Direction.ANY;
    }
}