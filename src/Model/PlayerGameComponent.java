package Model;

import Interfaces.Color;
import Interfaces.PlayerItem;
import Settings.UnitsList;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 6/05/2016.
 */
public class PlayerGameComponent extends AbstractFactory {

    @Override
    public PlayerColor getColor() {
        return new PlayerColor(46, 96, 234);
    }

    @Override
    public ArrayList<GameItem> getPlayerItem(int numberOfItems) {

        ArrayList<GameItem> units = new ArrayList<>();
        units.add(UnitsList.jet);
        for (int i = 1; i < numberOfItems; i++) units.add(UnitsList.army);
        return units;
    }

    @Override
    boolean isPlayerOne() {
        return false;
    }
}
