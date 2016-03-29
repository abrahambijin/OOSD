package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Sniper extends Weapon
{
    private Point head;

    public Sniper()
    {
        super(3, 35);
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
        shootingOptions.add(new Point((xPos + (2 * headXCoordinate)),
                (yPos + (2 * headYCoordinate))));
        shootingOptions.add(new Point((xPos + (3 * headXCoordinate)),
                (yPos + (3 * headYCoordinate))));
        return shootingOptions;
    }

    public void updateHead(Point head)
    {
        this.head = head;
    }
}
