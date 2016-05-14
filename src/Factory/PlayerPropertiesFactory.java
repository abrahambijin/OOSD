package Factory;

import Interfaces.AbstractPlayerPropertiesFactory;

/**
 * Created by mitulmanish on 6/05/2016.
 */


public class PlayerPropertiesFactory
{

    private static int  NO_OF_PLAYERS = -1;

    public static AbstractPlayerPropertiesFactory getPlayerPropertyFactory(){

        NO_OF_PLAYERS++;

        if(NO_OF_PLAYERS == 0){
            return new AlphaPropertiesFactory();
        }
        else{
            return new BetaPropertiesFactory();
        }
    }


}