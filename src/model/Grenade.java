package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Grenade extends Weapon
{
    private Point head;

    public Grenade()
    {
        super(1, 30);
        this.head = null;
    }


    @Override
    public ArrayList<Point> weaponRange(Point point)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        int headXCoordinate = head.getXCoordinate();
        int headYCoordinate = head.getYCoordinate();
        int xPos = point.getXCoordinate();
        int yPos = point.getYCoordinate();
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

    public void updateHead(Point head)
    {
        this.head = head;
    }
}
