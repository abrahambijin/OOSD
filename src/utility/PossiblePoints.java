package utility;

import model.Direction;
import model.GameItem;
import model.Position;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bijin on 14-Apr-16.
 */
public final class PossiblePoints
{
    private PossiblePoints()
    {
    }

    public static ArrayList<Position> getPossiblePoints(Position position, int limit,
                                                        Direction direction)
    {
        ArrayList<Position> positionOptions = new ArrayList<>();
        if (direction != Direction.STRAIGHT_LINE)
            positionOptions.addAll(getDiagonalOptions(position, limit));
        if (direction != Direction.DIAGONAL)
            positionOptions.addAll(getStraightLineOptions(position, limit));
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
                    positionOptions.add(new Position(xpos+i, ypos+j));
        return positionOptions;
    }

    private static ArrayList<Position> getDiagonalOptions(Position location,
                                                          int limit)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        ArrayList<Position> diagonalOptions = new ArrayList<>();
        for (int i = 1; i <= limit; i++)
        {
            diagonalOptions.add(new Position((xPos - i), (yPos - i)));
            diagonalOptions.add(new Position((xPos - i), (yPos + i)));
            diagonalOptions.add(new Position((xPos + i), (yPos - i)));
            diagonalOptions.add(new Position((xPos + i), (yPos + i)));
        }
        return diagonalOptions;
    }

    private static ArrayList<Position> getStraightLineOptions(Position location,
                                                              int limit)
    {
        int xPos = location.getXCoordinate();
        int yPos = location.getYCoordinate();
        ArrayList<Position> straightLineShootingOptions = new ArrayList<>();
        for (int i = 1; i <= limit; i++)
        {
            straightLineShootingOptions.add(new Position((xPos - i), yPos));
            straightLineShootingOptions.add(new Position(xPos, (yPos + i)));
            straightLineShootingOptions.add(new Position((xPos + i), yPos));
            straightLineShootingOptions.add(new Position(xPos, (yPos - i)));
        }
        return straightLineShootingOptions;
    }

    // find empty points on the warzone so that game extras can be populated on the warzone randomly
    // after initial game items have been laid down on the warzone , find the empty positions and select random positions
    private static ArrayList<Position> getEmptySlotsOnBoard(GameItem [][] warZone){
        ArrayList<Position> emptySpots = null;
        for (int row = 0; row < warZone.length; row++){
            for(int col = 0; col < warZone.length; col++){
                if (warZone[row][col] == null) {
                    emptySpots.add(new Position(row, col));
                }
            }
        }
        return emptySpots;
    }

    public static Position  getRandomEmptySlotOnBoard(GameItem [][] warZone){
        ArrayList<Position> emptyLocations = getEmptySlotsOnBoard(warZone);
        return emptyLocations.get(new Random().nextInt(emptyLocations.size()) + 1);
    }
}
