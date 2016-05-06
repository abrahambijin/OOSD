package Model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 6/05/2016.
 */

abstract class AbstractFactory {

    abstract PlayerColor getColor();
    abstract ArrayList<GameItem> getPlayerItem(int numberOfPieces) ;
    abstract boolean isPlayerOne();
}