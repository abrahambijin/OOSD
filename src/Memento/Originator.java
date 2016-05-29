package Memento;

import Model.Game;

import java.io.*;

/**
 * Created by mitulmanish on 29/05/2016.
 */
public class Originator
{

    public static int COUNTER = 0;
    public static String SAVE_GAME_LOCATION =
            "undoGame" + Integer.toString(COUNTER) + ".txt";

    private void set()
    {
        if (COUNTER < 6)
        {
            COUNTER++;
        }
        else
            COUNTER = 1;

        SAVE_GAME_LOCATION = "undoGame" + Integer.toString(COUNTER) + ".txt";
    }

    public Memento saveMemento(Game game)
    {
        // always call the set method before calling the saveMemento function
        set();
        try
        {
            OutputStream outputStream =
                    new FileOutputStream(SAVE_GAME_LOCATION);
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(game);
            outputStream.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return new Memento(SAVE_GAME_LOCATION);
    }


    /**
     * @param memento : this memento object is fetched from the careTaker stack eg.
     *                originator.restoreFromMemento(caretaker.getMemento(1), gameController);
     */
    public Game restoreMemento(Memento memento)
    {

        SAVE_GAME_LOCATION = memento.getSavedState();

        Game game = null;
        try
        {
            InputStream inputStream = new FileInputStream(SAVE_GAME_LOCATION);
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(inputStream);
            game = (Game) objectInputStream.readObject();
            inputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return game;
    }
}
