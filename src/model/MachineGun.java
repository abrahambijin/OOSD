package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class MachineGun extends Weapon{
    public MachineGun() {
        super(1, 17);
    }

    @Override
    public ArrayList<Point> weaponRange(Point point)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        shootingOptions.addAll(super.getStraightLineShootingOptions(point));
        return shootingOptions;
    }
}
