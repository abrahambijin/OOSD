package Interfaces;

import Model.GameItem;
import Utility.PlayerColor;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 6/05/2016.
 */

public interface AbstractPlayerPropertiesFactory
{

    PlayerColor getColor();
    ArrayList<GameItem> getPlayerItem(int numberOfPieces) ;
    boolean isPlayerOne();
}