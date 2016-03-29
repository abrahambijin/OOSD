package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Cannon extends Weapon{
    public Cannon() {
        super(2, 15);
    }


    @Override
    public ArrayList<Point> weaponRange(Point point)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        shootingOptions.addAll(super.getStraightLineShootingOptions(point));
        return shootingOptions;
    }
}
