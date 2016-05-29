package Memento;

import Model.Game;
import Settings.GameSettings;

import java.util.LinkedList;

/**
 * Created by mitulmanish on 29/05/2016.
 */
public class CareTaker
{

    private LinkedList<Memento> savedGameStates;

    public CareTaker()
    {
        savedGameStates = new LinkedList<>();
    }

    public void store(Memento memento)
    {
        savedGameStates.addFirst(memento);

        if (savedGameStates.size() > ((GameSettings.MAX_POSSIBLE_UNDO * 3) + 1))
            savedGameStates.pollLast();
    }

    public Memento load(int undoStage)
    {
        if (undoStage < 0 || undoStage > GameSettings.MAX_POSSIBLE_UNDO)
            return null;

        for(int i = 0; i < 2*undoStage; i++)
            savedGameStates.pollFirst();

        System.out.println("Care Taker: Load Game");
        return (savedGameStates.pollFirst());
    }
}

