package interfaces;

import model.Direction;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 28/04/2016.
 */
public interface Weapon
{

    String getName();

    int getRange();

    int getDamage();

    Direction getDirection();
}
