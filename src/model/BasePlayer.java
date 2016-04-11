package model;

/**
 * Created by mitulmanish on 11/04/2016.
 */
public class BasePlayer extends Player {

    private GameItem base;

    public BasePlayer(String name, GameItem item1, GameItem item2, GameItem base) {
        super(name, item1, item2);
        this.base = base;
    }

    public GameItem [] getItems(){
        GameItem [] items = {super.item1, super.item2, base};
        return items;
    }
}
