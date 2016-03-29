package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Ak47 extends Weapon
{
    public Ak47()
    {
        super(2, 15);
    }

    @Override
    public ArrayList<Point> weaponRange(Point point)
    {
        int xPosition = point.getxCoordinate();
        int yPosition = point.getyCoordinate();
        ArrayList<Point> shootingOptions = new ArrayList<>();
        for (int i = super.getRange(); i > 0; i--)
        {
            shootingOptions.add(new Point((xPosition - i), (yPosition - i)));
            shootingOptions.add(new Point((xPosition - i), yPosition));
            shootingOptions.add(new Point((xPosition - i), (yPosition + i)));
            shootingOptions.add(new Point(xPosition, (yPosition + i)));
            shootingOptions.add(new Point((xPosition + i), (yPosition + i)));
            shootingOptions.add(new Point((xPosition + i), yPosition));
            shootingOptions.add(new Point((xPosition + i), (yPosition - i)));
            shootingOptions.add(new Point(xPosition, (yPosition - i)));
        }
        return shootingOptions;
    }
}
