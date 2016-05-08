package Model;

import Utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Board
{

    private GameItem[][] warZone;
    private Position basePosition;
    private final int BOARD_SIZE;

    public Board(int boardSize)
    {
        BOARD_SIZE = boardSize;
        this.warZone = new GameItem[BOARD_SIZE][BOARD_SIZE];
    }

    private boolean placeGameUnit(GameItem item, Position position)
    {
        int xCoordinate = position.getXCoordinate();
        int yCoordinate = position.getYCoordinate();
        // the cell must be empty to place a new game item
        if (warZone[xCoordinate][yCoordinate] == null)
        {
            setItemOnWarZone(position, item);
            return true;
        }
        return false;
    }

    public GameItem getUnit(Position location)
    {
        return warZone[location.getXCoordinate()][location.getYCoordinate()];
    }

    public boolean placePlayerUnit(GameItem item, Position preferredLocation,
                                   boolean isPlayerOne)
    {
        try
        {
            boolean successfullyPlaced = false;
            if (item instanceof Base)
            {
                successfullyPlaced = placeGameUnit(item, preferredLocation);
                if (successfullyPlaced)
                {
                    basePosition = preferredLocation;
                    item.setPosition(preferredLocation);
                }
            }
            else
            {
                ArrayList<Position> possiblePositions =
                        possiblePositionsToPlacePlayerUnits(isPlayerOne);
                if (possiblePositions.contains(preferredLocation))
                {
                    successfullyPlaced = placeGameUnit(item, preferredLocation);
                    if (successfullyPlaced)
                        item.setPosition(preferredLocation);
                }
            } return successfullyPlaced;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    public ArrayList<Position> possiblePositionsToPlacePlayerUnits(
            boolean isPlayerOne)
    {
        return PossiblePoints
                .getPossiblePoints(basePosition, BOARD_SIZE, isPlayerOne);
    }

    public boolean move(Position currentPosition, Position newPosition)
    {
        boolean success = false;
        int xCoordinate = currentPosition.getXCoordinate();
        int yCoordinate = currentPosition.getYCoordinate();

        GameItem item = warZone[xCoordinate][yCoordinate];
        if (item != null && item instanceof Unit)
        {
            if (item instanceof Tower)
            {
                ((Tower) item).move(newPosition);
                success = true;
            }
            else
            {
                try
                {
                    success = placeGameUnit(item, newPosition);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    return false;
                }
                if (success)
                {
                    ((Unit) item).move(newPosition);
                    setPointToNull(currentPosition);
                }
            }
        }
        return success;
    }

    public ArrayList<Position> filterMovePositions(
            HashMap<Position, ArrayList<Position>> positions)
    {
        ArrayList<Position> possiblePositions = new ArrayList<>();

        for (ArrayList<Position> points : positions.values())
            for (Position candidatePosition : points)
            {
                try
                {
                    if (getUnit(candidatePosition) != null)
                        break;
                    possiblePositions.add(candidatePosition);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    break;
                }
            }
        return possiblePositions;
    }

    private void setPointToNull(Position location)
    {
        warZone[location.getXCoordinate()][location.getYCoordinate()] = null;
    }

    private void setItemOnWarZone(Position location, GameItem item)
    {
        warZone[location.getXCoordinate()][location.getYCoordinate()] = item;
    }

    public int getBOARD_SIZE()
    {
        return BOARD_SIZE;
    }
}
