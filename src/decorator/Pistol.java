package decorator;

import model.Direction;
import model.Position;
import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 27/04/2016.
 */
public class Pistol extends WeaponDecorator {

    String overriddenName;

    public Pistol(FireArm decoratedWeapon, String name) {
        super(decoratedWeapon);
        this.overriddenName = name;
    }

    public Pistol(FireArm decoratedWeapon) {
        super(decoratedWeapon);
    }

    public String getName() {
        if(overriddenName == null) return super.getName();
        else return overriddenName;
    }

    @Override
    public int getRange() {
        return super.getRange();
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 10;
    }

    @Override
    public Direction getDirection() {
        return super.getDirection();
    }

    @Override
    public ArrayList<Position> getWeaponRange(Position location) {
        return PossiblePoints.getPossiblePoints(location,getRange(), getDirection());
    }
}
