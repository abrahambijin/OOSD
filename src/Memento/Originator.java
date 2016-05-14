package Memento;

import Model.Game;

/**
 * Created by mitulmanish on 14/05/2016.
 */
public class Originator {

    private Game state;

    public void set(Game state) {
        System.out.println("Originator: Setting state to "+state);
        this.state = state;
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }

    public void restoreFromMemento(Memento memento) {
        state = memento.getSavedState();
        System.out.println("Originator: State after restoring from Memento: "+state);
    }
}
