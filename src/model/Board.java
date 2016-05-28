package Model;

import Utility.PossiblePoints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
        // The cell must be empty to place a new game item
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
        boolean successfullyPlaced = false;
        if (isPositionOnBoard(preferredLocation))
        {
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
            }
        }
        return successfullyPlaced;
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
                if (isPositionOnBoard(newPosition))
                {
                    success = placeGameUnit(item, newPosition);
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
                if (!isPositionOnBoard(candidatePosition) ||
                        getUnit(candidatePosition) != null)
                    break;

                possiblePositions.add(candidatePosition);

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

    public boolean isPositionOnBoard(Position position)
    {
        return (position.getXCoordinate() >= 0 &&
                position.getXCoordinate() < BOARD_SIZE &&
                position.getYCoordinate() >= 0 &&
                position.getYCoordinate() < BOARD_SIZE);
    }

    public boolean hit(Position itemLocation, Position targetLocation,
                       String weaponName)
    {
        boolean success = false;
        GameItem item = getUnit(itemLocation);

        if (item instanceof Unit)
        {
            GameItem target = getUnit(targetLocation);
            if (target != null)
            {
                target.getHit(((Unit) item).hit(weaponName));

                if (!target.isActive())
                    setPointToNull(targetLocation);
                success = true;
            }
        }
        return success;
    }

    public boolean isBaseActive()
    {
        return getUnit(basePosition) != null;
    }

    public ArrayList<Position> addObstacles()
    {
        Random generator = new Random();
        ArrayList<Position> positions = new ArrayList<>();

        int limit = BOARD_SIZE * 2 / 5;
        for (int i = 0; i < limit; i++)
        {
            Position p;
            do
            {
                int x = generator.nextInt(BOARD_SIZE);
                int y = generator.nextInt(BOARD_SIZE);
                p = new Position(x, y);
            } while (!placeGameUnit(new Obstacles(), p));

            positions.add(p);
            getUnit(p).setPosition(p);
        }
        return positions;
    }

    public ArrayList<Position> occupiedPositions()
    {
        ArrayList<Position> positionsOccupied = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                if (warZone[i][j] != null)
                    positionsOccupied.add(new Position(i,j));

        return positionsOccupied;
    }

}
