package Memento;

import Model.Game;

/**
 * Created by mitulmanish on 14/05/2016.
 */
public class Memento {

    private Game game;

    public Memento(Game game) {
        this.game = game;
    }

    public Game getSavedState() {
        return game;
    }
}
