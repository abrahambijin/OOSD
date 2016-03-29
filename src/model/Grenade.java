package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Grenade extends Weapon{
    public Grenade() {
        super(1, 30);
    }

    @Override
    public ArrayList<Point> weaponRange() {
        return null;
    }
}
