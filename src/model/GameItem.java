package Model;

import Utility.Position;

import java.io.Serializable;
import java.util.Observable;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public abstract class GameItem extends Observable implements Serializable
{

    private String name;
    private Position position;
    private String imageIconPath;
    private int health;

    public GameItem(String name)
    {
        this(name, 50);
    }

    public GameItem(String name, int health)
    {
        this.name = name;
        this.health = health;
        this.imageIconPath = "Images/GameItems/" + name + ".png";
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public String getName()
    {
        return name;
    }

    public String getImageIconPath()
    {
        return imageIconPath;
    }

    public int getHealth()
    {
        return health;
    }

    protected void setImageIconPath(String imageIconPath)
    {
        this.imageIconPath = imageIconPath;
    }

    public void getHit(int damage)
    {
        health -= damage;
        if(!isActive())
        {
            System.out.println("Origin");
            setChanged();
            notifyObservers();
        }
    }

    public boolean isActive()
    {
        return health > 0;
    }

}
