package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Pistol extends Weapon {
    public Pistol() {
        super(1, 20);
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
