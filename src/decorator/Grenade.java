package decorator;

import interfaces.WeaponWithHead;
import model.Direction;
import model.Position;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 27/04/2016.
 */
public class Grenade extends WeaponDecorator implements WeaponWithHead {

    String overriddenName;

    public Grenade(FireArm decoratedWeapon, String name) {
        super(decoratedWeapon);
        this.overriddenName = name;
    }

    public Grenade(FireArm decoratedWeapon) {
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
    public ArrayList<Position> weaponRange(Position location, Position head)
    {
        ArrayList<Position> shootingOptions = new ArrayList<>();
        int headXCoordinate = head.getXCoordinate();
        int headYCoordinate = head.getYCoordinate();
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        shootingOptions.add(new Position((xPos + headXCoordinate),
                (yPos + headYCoordinate)));
        if (headXCoordinate == 0)
        {
            shootingOptions
                    .add(new Position((xPos - 1), (yPos + headYCoordinate)));
            shootingOptions
                    .add(new Position((xPos + 1), (yPos + headYCoordinate)));
        }
        else if (headYCoordinate == 0)
        {
            shootingOptions
                    .add(new Position((xPos + headXCoordinate), (yPos - 1)));
            shootingOptions
                    .add(new Position((xPos + headXCoordinate), (yPos + 1)));
        }
        else
        {
            shootingOptions.add(new Position((xPos + headXCoordinate), yPos));
            shootingOptions.add(new Position(xPos, (yPos + headYCoordinate)));
        }
        return shootingOptions;
    }


}
