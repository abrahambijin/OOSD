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
    public ArrayList<Point> weaponRange() {
        return null;
    }
}
