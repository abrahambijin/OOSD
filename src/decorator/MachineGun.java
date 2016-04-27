package decorator;

import model.Direction;
import model.Position;
import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 27/04/2016.
 */

class MachineGun extends WeaponDecorator{

    String overrriddenName;

    public MachineGun(FireArm decoratedWeapon) {
        super(decoratedWeapon);
    }

    public MachineGun(FireArm decoratedWeapon, String name) {
        super(decoratedWeapon);
        this.overrriddenName = name;
    }

    @Override
    public String getName() {

        if(overrriddenName == null) return super.getName();
        else return overrriddenName;
    }

    @Override
    public int getRange() {
        return super.getRange();
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 7;
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


