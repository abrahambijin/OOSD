package model;

import interfaces.WeaponWithHead;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Sniper extends Weapon implements WeaponWithHead
{
    public Sniper()
    {
        super("Sniper",3, 35,Direction.CUSTOM);
    }

    @Override
    public ArrayList<Position> weaponRange(Position currentPosition, Position head)
    {
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
