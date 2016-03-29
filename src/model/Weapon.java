package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public abstract class Weapon {

    int range;
    int damage;

    public Weapon(int range, int damage) {
        this.range = range;
        this.damage = damage;
    }

    public abstract ArrayList<Point> weaponRange(Point point);

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }
}
