package Model;

import java.io.Serializable;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Position implements Serializable
{

    private int xCoordinate;
    private int yCoordinate;

    public Position(int xCoordinate, int yCoordinate)
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

    private boolean equals(Position position)
    {
        return ((position.getXCoordinate() == xCoordinate) &&
                (position.getYCoordinate() == yCoordinate));
    }

    @Override
    public boolean equals(Object o)
    {
        return o != null && o instanceof Position && equals((Position) o);
    }

    public String toString()
    {
        return "(" + xCoordinate + ", " + yCoordinate + ")";
    }

    public int hashCode()
    {
        return toString().hashCode();
    }

}