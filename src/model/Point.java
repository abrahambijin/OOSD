package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Point
{

    private int xCoordinate;
    private int yCoordinate;

    public Point(int xCoordinate, int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate()
    {
        return xCoordinate;
    }

    public int getYCoordinate()
    {
        return yCoordinate;
    }

    public boolean equals(Point point)
    {
        return ((point.getXCoordinate() == xCoordinate) &&
                (point.getYCoordinate() == yCoordinate));
    }

    public String toString()
    {
        return "(" + xCoordinate + ", " + yCoordinate + ")";
    }

    public boolean isWithInRange(Point point, int limit)
    {
        return ((xCoordinate - limit) <= point.getXCoordinate() &&
                point.getXCoordinate() <= (xCoordinate + limit) &&
                (yCoordinate - limit) <= point.getYCoordinate() &&
                point.getYCoordinate() <= (yCoordinate + limit));

    }
}