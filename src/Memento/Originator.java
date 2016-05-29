package Memento;

import Controller.GameController;
import Model.Game;

import java.io.*;

/**
 * Created by mitulmanish on 29/05/2016.
 */
public class Originator {

    public static int COUNTER = 0;
    public static String SAVE_GAME_LOCATION =
            "undoGame" + Integer.toString(COUNTER) + ".txt";

    public void set() {
        System.out.println("Originator: Saving to Memento.");
        if (COUNTER < 6) {
            COUNTER++;
        } else COUNTER = 1;

        SAVE_GAME_LOCATION = "undoGame" + Integer.toString(COUNTER) + ".txt";
    }

    public Memento saveToMemento(GameController gameController) {

        // always call the set method before calling the saveToMememto function

        try {
            OutputStream outputStream = new FileOutputStream(SAVE_GAME_LOCATION);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(gameController.getGame());
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Memento(SAVE_GAME_LOCATION);
    }


    /**
     *
     * @param memento : this memento object is fetched from the careTaker stack eg.
     *                originator.restoreFromMemento(caretaker.getMemento(1), gameController);
     * @param gameController
     */
    public void restoreFromMemento(Memento memento, GameController gameController) {

        SAVE_GAME_LOCATION = memento.getSavedState();

        try {
            InputStream inputStream = new FileInputStream(SAVE_GAME_LOCATION);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Game game = (Game)objectInputStream.readObject();
            gameController.setGame(game);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
