package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Weapon
{

    private int range;
    private int damage;
    private boolean canShootDiagonally;
    private boolean canShootStraight;

    public Weapon(int range, int damage, boolean canShootDiagonally,
                  boolean canShootStraight)
    {
        this.range = range;
        this.damage = damage;
        this.canShootDiagonally = canShootDiagonally;
        this.canShootStraight = canShootStraight;
    }

    public ArrayList<Point> weaponRange(Point point)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        if (canShootDiagonally)
            shootingOptions.addAll(getDiagonalShootingOptions(point));
        if (canShootStraight)
            shootingOptions.addAll(getStraightLineShootingOptions(point));
        return shootingOptions;
    }

    protected int getRange()
    {
        return range;
    }

    protected ArrayList<Point> getDiagonalShootingOptions(Point location)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        ArrayList<Point> diagonalShootingOptions = new ArrayList<>();
        for (int i = range; i > 0; i--)
        {
            diagonalShootingOptions.add(new Point((xPos - i), (yPos - i)));
            diagonalShootingOptions.add(new Point((xPos - i), (yPos + i)));
            diagonalShootingOptions.add(new Point((xPos + i), (yPos - i)));
            diagonalShootingOptions.add(new Point((xPos + i), (yPos + i)));
        }
        return diagonalShootingOptions;
    }

    protected ArrayList<Point> getStraightLineShootingOptions(Point location)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        ArrayList<Point> straightLineShootingOptions = new ArrayList<>();
        for (int i = range; i > 0; i--)
        {
            straightLineShootingOptions.add(new Point((xPos - i), yPos));
            straightLineShootingOptions.add(new Point(xPos, (yPos + i)));
            straightLineShootingOptions.add(new Point((xPos + i), yPos));
            straightLineShootingOptions.add(new Point(xPos, (yPos - i)));
        }
        return straightLineShootingOptions;
    }

    public int getDamage()
    {
        return damage;
    }
}
