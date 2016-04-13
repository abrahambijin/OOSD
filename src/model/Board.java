package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Board
{

    private GameItem[][] warZone;

    public Board(int boardSize)
    {

        this.warZone = new GameItem[boardSize][boardSize];
    }

    public void placeGameItem(GameItem item)
    {

        Point position = item.getPosition();
        int xCoordinate = position.getXCoordinate();
        int yCoordinate = position.getYCoordinate();
        // the cell must be empty to place a new game item
        if (warZone[xCoordinate][yCoordinate] == null)
        {
            warZone[xCoordinate][yCoordinate] = item;
        }
    }

    public GameItem[][] getWarZone()
    {
        return warZone;
    }

    public String getItemName(Point location)
    {
        GameItem item =
                warZone[location.getXCoordinate()][location.getYCoordinate()];
        if(item == null)
            return "     ";
        else
            return item.getName();
    }

}
