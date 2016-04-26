package decorator;

import model.Direction;

/**
 * Created by mitulmanish on 27/04/2016.
 */

abstract class WeaponDecorator implements FireArm{

    FireArm decoratedWeapon;

    public WeaponDecorator(FireArm decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

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