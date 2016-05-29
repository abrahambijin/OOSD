package Undo;

import Controller.*;
import Model.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by mitulmanish on 28/05/2016.
 */
public class SaveGameState
{
    public static int COUNTER = 0;
    public static String SAVE_GAME_LOCATION =
            "undoGame" + Integer.toString(COUNTER) + ".txt";
    private Queue<String> fileHolder = new LinkedList<>();



    public SaveGameState()
    {

    }

    public boolean saveGame(GameController gameController)
    {
        int checker = 0;

        if (COUNTER < 6)
        {
            COUNTER++;
        }
        else
            COUNTER = 1;

        SAVE_GAME_LOCATION = "undoGame" + Integer.toString(COUNTER) + ".txt";
        fileHolder.add(SAVE_GAME_LOCATION);

        try {
            OutputStream outputStream = new FileOutputStream(SAVE_GAME_LOCATION);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(gameController.getGame());
            outputStream.close();
            checker++;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return checker == 1;
    }

    public boolean loadGame(GameController gameController, int stage)
    {
        SAVE_GAME_LOCATION = "undoGame" + Integer.toString(stage) + ".txt";

        for(int index = stage * 2; index > 0; index -- ) {
            fileHolder.poll();
        }

        try {
            InputStream inputStream = new FileInputStream(SAVE_GAME_LOCATION);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Game game = (Game)objectInputStream.readObject();
            gameController.setGame(game);
            inputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


}
