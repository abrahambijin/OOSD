package decorator;

import model.Direction;
import model.Position;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/04/2016.
 */
public interface FireArm {

    String getName();
    int getRange();
    int getDamage();
    Direction getDirection();
    ArrayList<Position> getWeaponRange(Position location);
}
