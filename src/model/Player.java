package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Player {

    private String name;
    private Troop troop1;
    private Troop troop2;

    public Player(String name, Troop troop1, Troop troop2) {
        this.name = name;
        this.troop1 = troop1;
        this.troop2 = troop2;
    }

    public GameItem [] getItems(){
        return new Troop[]{troop1, troop2};
    }

    public String getName()
    {
        return name;
    }

    public Troop getTroop1()
    {
        return troop1;
    }

    public Troop getTroop2()
    {
        return troop2;
    }
}
