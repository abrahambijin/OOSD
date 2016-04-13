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
        super("Grenade",1, 30,false,false);
    }

    @Override
    public ArrayList<Point> weaponRange(Point location, Point head)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        int headXCoordinate = head.getXCoordinate();
        int headYCoordinate = head.getYCoordinate();
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        shootingOptions.add(new Point((xPos + headXCoordinate),
                (yPos + headYCoordinate)));
        if (headXCoordinate == 0)
        {
            shootingOptions
                    .add(new Point((xPos - 1), (yPos + headYCoordinate)));
            shootingOptions
                    .add(new Point((xPos + 1), (yPos + headYCoordinate)));
        }
        else if (headYCoordinate == 0)
        {
            shootingOptions
                    .add(new Point((xPos + headXCoordinate), (yPos - 1)));
            shootingOptions
                    .add(new Point((xPos + headXCoordinate), (yPos + 1)));
        }
        else
        {
            shootingOptions.add(new Point((xPos + headXCoordinate), yPos));
            shootingOptions.add(new Point(xPos, (yPos + headYCoordinate)));
        }
        return shootingOptions;
    }
}
