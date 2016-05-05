package interfaces;

import model.Position;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijin on 28-Apr-16.
 */
public interface Weapon
{
    int getDamage();

    HashMap<Position, ArrayList<Position>> getShootingOptions(
            Position currentLocation);

    String getName();
}
