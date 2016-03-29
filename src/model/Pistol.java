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
    public ArrayList<Point> weaponRange() {
        return null;
    }
}
