package decorator;

import interfaces.WeaponWithHead;
import model.Direction;
import model.Position;
import utility.PossiblePoints;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 27/04/2016.
 */
public class Sniper extends WeaponDecorator implements WeaponWithHead {

    String overriddenName;

    public Sniper(FireArm decoratedWeapon, String name) {
        super(decoratedWeapon);
        this.overriddenName = name;
    }

    public Sniper(FireArm decoratedWeapon) {
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
        return super.getDamage() + 25;
    }

    @Override
    public Direction getDirection() {
        return super.getDirection();
    }


    @Override
    public ArrayList<Position> weaponRange(Position currentPosition, Position head) {
        ArrayList<Position> shootingOptions = new ArrayList<>();
        int headXCoordinate = head.getXCoordinate();
        int headYCoordinate = head.getYCoordinate();
        int xPos = currentPosition.getXCoordinate();
        int yPos = currentPosition.getYCoordinate();
        for(int i=1; i<=super.getRange();i++)
            shootingOptions.add(new Position((xPos + (i * headXCoordinate)),
                    (yPos + (i * headYCoordinate))));
        shootingOptions.add(new Position((xPos + headXCoordinate),
                (yPos + headYCoordinate)));
        shootingOptions.add(new Position((xPos + (2 * headXCoordinate)),
                (yPos + (2 * headYCoordinate))));
        shootingOptions.add(new Position((xPos + (3 * headXCoordinate)),
                (yPos + (3 * headYCoordinate))));
        return shootingOptions;
    }
}
