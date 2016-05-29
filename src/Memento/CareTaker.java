package Memento;

import java.util.Stack;

/**
 * Created by mitulmanish on 29/05/2016.
 */
public class CareTaker {

    private Stack<Memento> savedGameStates;

    private Originator originator;

    public CareTaker()
    {
        savedGameStates = new Stack<>();
        originator = new Originator();
    }

    public void addMemento(Memento memento) { savedGameStates.add(memento); }

    public Memento getMemento(int undoStage) { return savedGameStates.get(undoStage); }
}

