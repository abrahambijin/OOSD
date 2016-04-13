package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class GameItem  {

    private String name;
    private Point position;
    int health;

    public GameItem(String name) {
        this(name,100);
    }

    public GameItem(String name, int health){
        this.name = name;
        this.health = health;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position)
    {
        this.position = position;
    }

    public String getName()
    {
        return name;
    }
}
