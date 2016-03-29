package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Sniper extends Weapon{
    public Sniper() {
        super(3, 35);
    }

    @Override
    public ArrayList<Point> weaponRange() {
        return null;
    }
}
