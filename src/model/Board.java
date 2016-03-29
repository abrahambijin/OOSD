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

}
