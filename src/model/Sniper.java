package model;

import interfaces.Weapon;
import interfaces.WeaponWithHead;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Sniper implements Weapon, WeaponWithHead{

    @Override
    public String getName() {
        return "Sniper";
    }

    @Override
    public int getRange() {
        return 3;
    }

    @Override
    public int getDamage() {
        return 35;
    }

    @Override
    public Direction getDirection() {
        return Direction.CUSTOM;
    }


    @Override
    public ArrayList<Position> getWeaponRange(Position currentPosition, Position head)
    {
        ArrayList<Position> shootingOptions = new ArrayList<>();
        int headXCoordinate = head.getXCoordinate();
        int headYCoordinate = head.getYCoordinate();
        int xPos = currentPosition.getXCoordinate();
        int yPos = currentPosition.getYCoordinate();
        for(int i=1; i <= getRange();i++)
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
