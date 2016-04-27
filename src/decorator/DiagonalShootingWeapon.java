package decorator;

import model.Direction;
import model.Position;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/04/2016.
 */
class DiagonalShootingWeapon implements FireArm {

    @Override
    public String getName() {
        return "I m a base diagonal line shooting thing";
    }

    @Override
    public int getRange() {
        return 2;
    }

    @Override
    public int getDamage() {
        return 20;
    }

    @Override
    public Direction getDirection() {
        return Direction.DIAGONAL;
    }

    @Override
    public ArrayList<Position> getWeaponRange(Position location) {
        return null;
    }
}