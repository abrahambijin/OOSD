package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Player {

    private String name;
    protected GameItem item1;
    protected GameItem item2;

    public Player(String name, GameItem item1, GameItem item2) {
        this.name = name;
        this.item1 = item1;
        this.item2 = item2;
    }

    public GameItem [] getItems(){
        GameItem [] items = {item1, item2};
        return items;
    }
}
