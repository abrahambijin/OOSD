package model;

/**
 * Created by mitulmanish on 11/04/2016.
 */
public class BasePlayer extends Player {

    private GameItem base;

    public BasePlayer(String name, Troop item1, Troop item2) {
        super(name, item1, item2);
        this.base = new GameItem("Base",new Point(0, 0), 500);
    }

    public GameItem [] getItems(){
        GameItem [] items = {super.getTroop1(), super.getTroop2(), base};
        return items;
    }
}
