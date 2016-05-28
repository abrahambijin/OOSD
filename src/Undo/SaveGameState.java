package Undo;

import Controller.*;
import Model.*;
import java.io.*;


/**
 * Created by mitulmanish on 28/05/2016.
 */
public class SaveGameState
{
    public static int COUNTER = 0;
    public static String SAVE_GAME_LOCATION =
            "undoGame" + Integer.toString(COUNTER) + ".txt";
    public static String SAVE_VIEW_LOCATION =
            "undoView" + Integer.toString(COUNTER) + ".txt";

    public SaveGameState()
    {

    }

    public boolean saveGame(GameController gameController)
    {
        int checker = 0;

        if (COUNTER < 3)
        {
            COUNTER++;
        }
        else
            COUNTER = 1;

        SAVE_GAME_LOCATION = "undoGame" + Integer.toString(COUNTER) + ".txt";

        try {
            OutputStream os = new FileOutputStream(SAVE_GAME_LOCATION);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(gameController.getGame());
            os.close();
            checker++;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return checker == 1 ? true: false;
    }

    public boolean loadGame(GameController gameController, int stage)
    {
        SAVE_GAME_LOCATION = "undoGame" + Integer.toString(stage) + ".txt";

        try {
            InputStream is = new FileInputStream(SAVE_GAME_LOCATION);
            ObjectInputStream ois = new ObjectInputStream(is);
            Game game = (Game)ois.readObject();
            gameController.setGame(game);
            is.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


}
