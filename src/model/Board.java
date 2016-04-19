package model;

import utility.PossiblePoints;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Board
{

    private GameItem[][] warZone;
    private Position basePosition;
    private final int BOARD_SIZE;
    private final int INITIAL_DISTANCE_FROM_BASE;

    public Board(int boardSize)
    {
        BOARD_SIZE = boardSize;
        INITIAL_DISTANCE_FROM_BASE = 2;
        this.warZone = new GameItem[BOARD_SIZE][BOARD_SIZE];
    }

    private boolean placeGameItem(GameItem item, Position position)
    {
        int xCoordinate = position.getXCoordinate();
        int yCoordinate = position.getYCoordinate();
        // the cell must be empty to place a new game item
        if (warZone[xCoordinate][yCoordinate] == null)
        {
            warZone[xCoordinate][yCoordinate] = item;
            return true;
        }
        return false;
    }

    public GameItem[][] getWarZone()
    {
        return warZone;
    }

    public GameItem getItem(Position location)
    {
        return warZone[location.getXCoordinate()][location.getYCoordinate()];
    }

    public boolean placePlayerOneItem(GameItem item, Position preferredLocation)
    {
        try
        {
            boolean successfullyPlaced;
            if (item instanceof Base)
            {
                successfullyPlaced = placeGameItem(item, preferredLocation);
                if (successfullyPlaced)
                {
                    basePosition = preferredLocation;
                    item.setPosition(preferredLocation);
                }
            }
            else
            {
                if (possiblePointsToPlacePlayerOneItem()
                        .contains(preferredLocation))
                {
                    successfullyPlaced = placeGameItem(item, preferredLocation);
                    if (successfullyPlaced)
                        item.setPosition(preferredLocation);
                }
                else
                    successfullyPlaced = false;
            }
            return successfullyPlaced;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    public ArrayList<Position> possiblePointsToPlacePlayerOneItem()
    {
        return PossiblePoints
                .getPointsInRange(basePosition, INITIAL_DISTANCE_FROM_BASE);
    }

    public ArrayList<Position> possiblePointsToPlacePlayerItem()
    {
        ArrayList<Position> listOfPositions = new ArrayList<>();
        if (!(basePosition.getYCoordinate() < ((BOARD_SIZE - 1) / 2)))
        {
            listOfPositions.addAll(getBorder(0, false));
        }
        if (!(basePosition.getYCoordinate() > ((BOARD_SIZE - 1) / 2)))
        {
            listOfPositions.addAll(getBorder(BOARD_SIZE - 1, false));
        }
        if (!(basePosition.getXCoordinate() < ((BOARD_SIZE - 1) / 2)))
        {
            listOfPositions.addAll(getBorder(0, true));
        }
        if (!(basePosition.getXCoordinate() > ((BOARD_SIZE - 1) / 2)))
        {
            listOfPositions.addAll(getBorder(BOARD_SIZE - 1, true));
        }
        return listOfPositions;
    }

    public boolean placePlayerItem(GameItem item, Position preferredLocation)
    {
        try
        {
            boolean successfullyPlaced = false;

            if (possiblePointsToPlacePlayerItem().contains(preferredLocation))
            {
                successfullyPlaced = placeGameItem(item, preferredLocation);
                if (successfullyPlaced)
                    item.setPosition(preferredLocation);
            }
            return successfullyPlaced;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    private ArrayList<Position> getBorder(int fixedValue, boolean xIsFixed)
    {
        ArrayList<Position> listOfPositions = new ArrayList<>();
        if (xIsFixed)
            for (int i = 0; i < BOARD_SIZE; i++)
                listOfPositions.add(new Position(fixedValue, i));
        else
            for (int i = 1; i < BOARD_SIZE - 1; i++)
                listOfPositions.add(new Position(i, fixedValue));
        return listOfPositions;
    }

    public boolean move(Position currentPosition, Position newPosition)
    {
        boolean success = false;
        int xCoordinate = currentPosition.getXCoordinate();
        int yCoordinate = currentPosition.getYCoordinate();

        GameItem item = warZone[xCoordinate][yCoordinate];
        if (item != null && item instanceof Troop)
        {
            if(item instanceof Tower)
            {
                ((Tower) item).move(newPosition);
                success = true;
            }
            else
            {
                try
                {
                    success = placeGameItem(item, newPosition);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    return false;
                }
                if (success)
                {
                    ((Troop) item).move(newPosition);
                    setPointToNull(currentPosition);
                }
            }
        }
        return success;
    }

    public ArrayList<Position> filterMovePositions(ArrayList<Position> positions)
    {
        ListIterator<Position> iterator = positions.listIterator();
        while (iterator.hasNext())
        {
            Position position = iterator.next();
            try
            {
                if (getItem(position) != null)
                {
                    iterator.remove();
                }
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                iterator.remove();
            }
        }

        return positions;
    }

    private void setPointToNull(Position location)
    {
        warZone[location.getXCoordinate()][location.getYCoordinate()] = null;
    }



}
