package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Board {

    private final int BOARDSIZE = 10;

    private GameItem[][] warZone;

    public Board() {
        this.warZone = new GameItem[BOARDSIZE][BOARDSIZE];
    }

    public void placeGameItem(GameItem item){

        Point position = item.getPosition();
        int xCoordinate = position.getXCoordinate();
        int yCoordinate = position.getYCoordinate();
        // the cell must be empty to place a new game item
        if(warZone[xCoordinate][yCoordinate] == null){
            warZone[xCoordinate][yCoordinate] = item;
        }
    }

}
