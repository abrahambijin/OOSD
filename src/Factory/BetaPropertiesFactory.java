package Factory;

import Interfaces.AbstractPlayerPropertiesFactory;
import Model.GameItem;
import Model.PlayerColor;
import Settings.UnitsList;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 6/05/2016.
 */
class BetaPropertiesFactory implements AbstractPlayerPropertiesFactory
{

    @Override
    public PlayerColor getColor()
    {
        return new PlayerColor(46, 96, 234);
    }

    @Override
    public ArrayList<GameItem> getPlayerItem(int numberOfItems)
    {

        ArrayList<GameItem> units = new ArrayList<>();
        units.add(UnitsList.getUnit("Jet"));
        for (int i = 1; i < numberOfItems; i++)
            units.add(UnitsList.getUnit("Army"));
        return units;
    }

    @Override
    public boolean isPlayerOne()
    {
        return false;
    }
}
