package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class GameItem  {

    private String name;
    private Point position;
    int health;

    public GameItem(String name) {
        this.name = name;
        health = 100;
    }

    public GameItem(String name,Point position, int health){
        this.position = position;
        this.health = health;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position)
    {
        this.position = position;
    }
}
