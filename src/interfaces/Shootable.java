package interfaces;

import model.Position;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 28/04/2016.
 */
public interface Shootable {
    ArrayList<Position> getWeaponRange(Position location);
}
