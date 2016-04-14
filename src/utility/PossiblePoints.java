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

    public static ArrayList<Point> getPossiblrPoints(Point position, int
            limit, Direction direction)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        if (direction != Direction.STRAIGHT_LINE)
            shootingOptions.addAll(getDiagonalOptions(position, limit));
        if (direction != Direction.DIAGONAL)
            shootingOptions.addAll(getStraightLineOptions(position, limit));
        return shootingOptions;
    }

    private static ArrayList<Point> getDiagonalOptions(Point location, int limit)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        ArrayList<Point> diagonalShootingOptions = new ArrayList<>();
        for (int i = limit; i > 0; i--)
        {
            diagonalShootingOptions.add(new Point((xPos - i), (yPos - i)));
            diagonalShootingOptions.add(new Point((xPos - i), (yPos + i)));
            diagonalShootingOptions.add(new Point((xPos + i), (yPos - i)));
            diagonalShootingOptions.add(new Point((xPos + i), (yPos + i)));
        }
        return diagonalShootingOptions;
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
