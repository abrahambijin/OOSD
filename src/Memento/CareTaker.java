package Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mitulmanish on 14/05/2016.
 */
public class CareTaker {

    private List<Memento> savedStates = new ArrayList<Memento>();

    public void addMemento(Memento memento) { savedStates.add(memento); }

    public Memento getMemento(int index) { return savedStates.get(index); }
}
