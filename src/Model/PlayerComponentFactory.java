package Model;

/**
 * Created by mitulmanish on 6/05/2016.
 */


public class PlayerComponentFactory {

    private static int  NO_OF_PLAYERS = -1;

    public static AbstractFactory getPlayerPropertyFactory(){

        NO_OF_PLAYERS++;

        if(NO_OF_PLAYERS == 0){
            return new PlayerOneGameComponent();
        }
        else{
            return new PlayerGameComponent();
        }
    }


}