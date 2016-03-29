package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class GameItem  {

    private Point position;
    int health;

    public GameItem(Point position) {
        this.position = position;
        health = 100;
    }
}
