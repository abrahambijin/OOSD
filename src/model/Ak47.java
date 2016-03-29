package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Ak47 extends Weapon
{
    public Ak47()
    {
        super(2, 15);
    }

    @Override
    public ArrayList<Point> weaponRange(Point point)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        shootingOptions.addAll(super.getDiagonalShootingOptions(point));
        shootingOptions.addAll(super.getStraightLineShootingOptions(point));
        return shootingOptions;
    }
}
