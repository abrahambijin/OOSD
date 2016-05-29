package Factory;

import Exceptions.ObjectAlreadyExistException;
import Interfaces.AbstractPlayerPropertiesFactory;
import Model.Base;
import Model.GameItem;
import Utility.PlayerColor;
import Settings.UnitsList;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 6/05/2016.
 */
class AlphaPropertiesFactory implements AbstractPlayerPropertiesFactory
{

    @Override
    public PlayerColor getColor()
    {
        return new PlayerColor(255, 50, 0);
    }

    @Override
    public ArrayList<GameItem> getPlayerItem(int numberOfItems)
    {
        ArrayList<GameItem> units = new ArrayList<>();
        try
        {
            units.add(Base.baseFactory());
        }
        catch (ObjectAlreadyExistException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        units.add(UnitsList.getUnit("Tower"));
        for (int i = 1; i < numberOfItems; i++)
            units.add(UnitsList.getUnit("Tank"));
        return units;
    }

    @Override
    public boolean isPlayerOne()
    {
        return true;
    }
}
