package utility;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bijin on 14-Apr-16.
 */
public final class PossiblePoints
{
    private PossiblePoints()
    {
    }

    public static HashMap<Position, ArrayList<Position>> getPossiblePoints(
            Position position, int limit, Direction direction)
    {
        HashMap<Position, ArrayList<Position>> positionOptions =
                new HashMap<>();
        if (direction != Direction.STRAIGHT_LINE)
            positionOptions.putAll(getDiagonalOptions(position, limit));
        if (direction != Direction.DIAGONAL)
            positionOptions.putAll(getStraightLineOptions(position, limit));
        return positionOptions;
    }

    public static ArrayList<Position> getPointsInRange(Position position,
                                                       int rangeLimit)
    {
        ArrayList<Position> positionOptions = new ArrayList<>();
        int xpos = position.getXCoordinate();
        int ypos = position.getYCoordinate();
        for (int i = (-1 * rangeLimit); i <= rangeLimit; i++)
            for (int j = (-1 * rangeLimit); j <= rangeLimit; j++)
                if (i != 0 || j != 0)
                    positionOptions.add(new Position(xpos + i, ypos + j));
        return positionOptions;
    }

    private static HashMap<Position, ArrayList<Position>> getDiagonalOptions(
            Position location, int limit)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();

        HashMap<Position, ArrayList<Position>> diagonalOptions =
                new HashMap<>();
        for (int i = -1; i <= 1; i += 2)
            for (int j = -1; j <= 1; j += 2)
                diagonalOptions.put(new Position(i, j), new ArrayList<>());

        for (int i = 1; i <= limit; i++)
        {
            diagonalOptions.get(new Position(-1, -1))
                    .add(new Position((xPos - i), (yPos - i)));
            diagonalOptions.get(new Position(-1, 1))
                    .add(new Position((xPos - i), (yPos + i)));
            diagonalOptions.get(new Position(1, -1))
                    .add(new Position((xPos + i), (yPos - i)));
            diagonalOptions.get(new Position(1, 1))
                    .add(new Position((xPos + i), (yPos + i)));
        }
        return diagonalOptions;
    }

    private static HashMap<Position, ArrayList<Position>> getStraightLineOptions(
            Position location, int limit)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();

        HashMap<Position, ArrayList<Position>> straightLineShootingOptions =
                new HashMap<>();
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                if (!(i == 0 && j == 0) && (i == 0 || j == 0))
                    straightLineShootingOptions
                            .put(new Position(i, j), new ArrayList<>());

        for (int i = 1; i <= limit; i++)
        {
            straightLineShootingOptions.get(new Position(-1, 0))
                    .add(new Position((xPos - i), yPos));
            straightLineShootingOptions.get(new Position(0, 1))
                    .add(new Position(xPos, (yPos + i)));
            straightLineShootingOptions.get(new Position(1, 0))
                    .add(new Position((xPos + i), yPos));
            straightLineShootingOptions.get(new Position(0, -1))
                    .add(new Position(xPos, (yPos - i)));
        }
        return straightLineShootingOptions;
    }
}
