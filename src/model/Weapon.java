package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public abstract class Weapon {

    int range;
    int damage;

    public Weapon(int range, int damage) {
        this.range = range;
        this.damage = damage;
    }

    public abstract ArrayList<Point> weaponRange(Point point);

    public int getRange() {
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
        ArrayList<Point>straightLineShootingOptions = new ArrayList<>();
        for (int i = range; i > 0; i--)
        {
            straightLineShootingOptions.add(new Point((xPos - i), yPos));
            straightLineShootingOptions.add(new Point(xPos, (yPos + i)));
            straightLineShootingOptions.add(new Point((xPos + i), yPos));
            straightLineShootingOptions.add(new Point(xPos, (yPos - i)));
        }
        return straightLineShootingOptions;
    }

    public int getDamage() {
        return damage;
    }
}
