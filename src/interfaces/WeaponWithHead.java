package interfaces;

import model.Position;

import java.util.ArrayList;

/**
 * Created by Bijin on 13-Apr-16.
 */
public interface WeaponWithHead
{
    ArrayList<Position> weaponRange(Position location, Position head);
}
