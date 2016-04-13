package interfaces;

import model.Point;

import java.util.ArrayList;

/**
 * Created by Bijin on 13-Apr-16.
 */
public interface WeaponWithHead
{
    ArrayList<Point> weaponRange(Point location, Point head);
}
