package model;

/**
 * Created by mitulmanish on 23/04/2016.
 */
public class Infantry extends GameItem {

    private Weapon weapon;

    public Infantry(String name, Weapon weapon) {
        super(name);
        this.weapon = weapon;
    }

    public Weapon getBonusWeapon() {
        return weapon;
    }
}
