package utility;

import model.Direction;
import model.Point;

import java.util.ArrayList;

/**
 * Created by Bijin on 14-Apr-16.
 */
public final class PossiblePoints
{
    private PossiblePoints(){}

    public static ArrayList<Point> getPossiblePoints(Point position, int
            limit, Direction direction)
    {
        ArrayList<Point> pointOptions = new ArrayList<>();
        if (direction != Direction.STRAIGHT_LINE)
            pointOptions.addAll(getDiagonalOptions(position, limit));
        if (direction != Direction.DIAGONAL)
            pointOptions.addAll(getStraightLineOptions(position, limit));
        return pointOptions;
    }

    private static ArrayList<Point> getDiagonalOptions(Point location, int limit)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        ArrayList<Point> diagonalOptions = new ArrayList<>();
        for (int i = limit; i > 0; i--)
        {
            diagonalOptions.add(new Point((xPos - i), (yPos - i)));
            diagonalOptions.add(new Point((xPos - i), (yPos + i)));
            diagonalOptions.add(new Point((xPos + i), (yPos - i)));
            diagonalOptions.add(new Point((xPos + i), (yPos + i)));
        }
        return diagonalOptions;
    }

    private static ArrayList<Point> getStraightLineOptions(Point location, int
        limit)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        ArrayList<Point> straightLineShootingOptions = new ArrayList<>();
        for (int i = limit; i > 0; i--)
        {
            straightLineShootingOptions.add(new Point((xPos - i), yPos));
            straightLineShootingOptions.add(new Point(xPos, (yPos + i)));
            straightLineShootingOptions.add(new Point((xPos + i), yPos));
            straightLineShootingOptions.add(new Point(xPos, (yPos - i)));
        }
        return straightLineShootingOptions;
    }
}
