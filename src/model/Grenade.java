package model;

import interfaces.WeaponWithHead;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Grenade extends Weapon implements WeaponWithHead
{
    public Grenade()
    {
        super("Grenade",1, 30,Direction.CUSTOM);
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
