package Memento;

import Settings.GameSettings;

import java.util.LinkedList;

/**
 * Created by mitulmanish on 29/05/2016.
 */
public class CareTaker
{
    private static int count;
    private LinkedList<Memento> savedGameStates;

    public CareTaker()
    {
        savedGameStates = new LinkedList<>();
        count=0;
    }

    public void store(Memento memento)
    {
        savedGameStates.addFirst(memento);

        if (savedGameStates.size() > GameSettings.MAX_POSSIBLE_UNDO * 6)
            savedGameStates.pollLast();

        count = savedGameStates.size();
    }

    public Memento load(int undoStage)
    {
        if (undoStage < 0 || undoStage > GameSettings.MAX_POSSIBLE_UNDO)
            return null;

        for(int i = 0; i < 2*undoStage; i++)
            savedGameStates.pollFirst();

        count = savedGameStates.size();
        return (savedGameStates.pollFirst());
    }

    public static int getCount()
    {
        return count;
    }
}

