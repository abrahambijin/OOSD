package model;

import interfaces.Weapon;

/**
 * Created by mitulmanish on 28/04/2016.
 */
abstract class WeaponDecorator implements Weapon {

    Weapon decoratedWeapon;

    public WeaponDecorator(Weapon decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    @Override
    public String getName() {
        return decoratedWeapon.getName();
    }

    @Override
    public int getRange() {
        return decoratedWeapon.getRange();
    }

    @Override
    public int getDamage() {
        return decoratedWeapon.getDamage();
    }

    @Override
    public Direction getDirection() {
        return decoratedWeapon.getDirection();
    }

}