package Memento;

import Model.Game;
import Settings.GameSettings;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by mitulmanish on 29/05/2016.
 */
public class CareTaker
{

    private LinkedList<Memento> savedGameStates;
    private Originator originator;

    public CareTaker()
    {
        savedGameStates = new LinkedList<>();
        originator = new Originator();

    }

    public void store(Game game)
    {
        savedGameStates.addFirst(originator.saveMemento(game));

        if (savedGameStates.size() > ((GameSettings.MAX_POSSIBLE_UNDO * 3) + 1))
            savedGameStates.pollLast();
    }

    public Game load(int undoStage)
    {
        if (undoStage < 0 || undoStage > GameSettings.MAX_POSSIBLE_UNDO)
            return null;

        for(int i = 0; i < 2*undoStage; i++)
            savedGameStates.pollFirst();

        System.out.println("Care Taker: Load Game");
        return originator.restoreMemento(savedGameStates.pollFirst());
    }
}

