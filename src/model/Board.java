package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Board
{

    private GameItem[][] warZone;
    private Point basePosition;
    private final int BOARD_SIZE;

    public Board(int boardSize)
    {
        BOARD_SIZE = boardSize;
        this.warZone = new GameItem[BOARD_SIZE][BOARD_SIZE];
    }

    private boolean placeGameItem(GameItem item, Point position)
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

    public String getItemName(Point location)
    {
        GameItem item =
                warZone[location.getXCoordinate()][location.getYCoordinate()];
        if (item == null)
            return "     ";
        else
            return item.getName();
    }

    public boolean placePlayerOneItem(GameItem item, Point preferredLocation)
    {
        try
        {
            boolean successfullyPlaced;
            if (item instanceof Base)
            {
                successfullyPlaced = placeGameItem(item, preferredLocation);
                if (successfullyPlaced)
                    basePosition = preferredLocation;
            }
            else
            {
                if (basePosition.isWithInRange(preferredLocation, 2))
                {
                    successfullyPlaced = placeGameItem(item, preferredLocation);
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

    public boolean placePlayerItem(GameItem item, Point preferredLocation)
    {
        try
        {
            boolean successfullyPlaced = false;
            if (((preferredLocation.getXCoordinate() == 0) ||
                    (preferredLocation.getXCoordinate() == BOARD_SIZE -1)
                    ) ||
                    ((preferredLocation.getYCoordinate() == 0) ||
                    (preferredLocation.getYCoordinate() == BOARD_SIZE -1)))
            {
                successfullyPlaced = basePosition
                        .isWithInRange(preferredLocation, BOARD_SIZE / 2) &&
                        placeGameItem(item, preferredLocation);
            }
            return successfullyPlaced;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

}
