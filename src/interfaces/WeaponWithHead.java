package interfaces;

import model.Position;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijin on 13-Apr-16.
 */
public interface WeaponWithHead
{
    HashMap<Position, ArrayList<Position>> getWeaponRange(Position location, Position head);
}
