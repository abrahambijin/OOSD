package decorator;

import model.Direction;

/**
 * Created by mitulmanish on 26/04/2016.
 */
public interface FireArm {

    String getName();
    int getRange();
    int getDamage();
    Direction getDirection();
}
