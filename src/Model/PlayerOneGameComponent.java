package Model;

import Exceptions.ObjectAlreadyExistException;
import Interfaces.Color;
import Interfaces.PlayerItem;
import Settings.UnitsList;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 6/05/2016.
 */
public class PlayerOneGameComponent extends AbstractFactory{

    @Override
    public PlayerColor getColor() {
        return new PlayerColor(255, 50, 0);
    }

    @Override
    public ArrayList<GameItem> getPlayerItem(int numberOfItems) {
        ArrayList<GameItem> units = new ArrayList<>();
        try{
            units.add(Base.baseFactory());
        } catch(ObjectAlreadyExistException e){ }

        units.add(UnitsList.tower);
        for (int i = 1; i < numberOfItems; i++) units.add(UnitsList.tank);
        return units;
    }

    @Override
    boolean isPlayerOne() {
        return true;
    }
}
