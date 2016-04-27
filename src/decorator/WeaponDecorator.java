package decorator;

import model.Direction;
import model.Position;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 27/04/2016.
 */

/*
The decorator pattern is used to extend or alter the functionality of objects at run- time by wrapping them in an object
of a decorator class.This provides a flexible alternative to using inheritance to modify behaviour.
*/

abstract class WeaponDecorator implements FireArm {

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

    @Override
    public ArrayList<Position> getWeaponRange(Position location) {
        return decoratedWeapon.getWeaponRange(location);
    }
}