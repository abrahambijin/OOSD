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

    private boolean equals(Point point)
    {
        return ((point.getXCoordinate() == xCoordinate) &&
                (point.getYCoordinate() == yCoordinate));
    }

    @Override
    public boolean equals(Object o)
    {
        return o != null && o instanceof Point && equals((Point) o);
    }

    public String toString()
    {
        return "(" + xCoordinate + ", " + yCoordinate + ")";
    }
}