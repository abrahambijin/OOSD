package decorator;

import model.Direction;
import model.Position;
import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 27/04/2016.
 */
public class Cannon extends WeaponDecorator {
    String overriddenName;

    public Cannon(FireArm decoratedWeapon, String name) {
        super(decoratedWeapon);
        this.overriddenName = name;
    }

    public Cannon(FireArm decoratedWeapon) {
        super(decoratedWeapon);
    }

    public String getName() {
        if(overriddenName == null) return super.getName();
        else return overriddenName;
    }

    @Override
    public int getRange() {
        return super.getRange() + 1;
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 5;
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

