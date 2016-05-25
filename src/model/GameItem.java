package Model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public abstract class GameItem
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
        this.imageIconPath = "Images/" + name + ".png";
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
    }

    public boolean isActive()
    {
        return health > 0;
    }

}
