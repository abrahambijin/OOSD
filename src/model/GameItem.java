package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public abstract class GameItem  {

    private String name;
    private Point position;
    private String imageIconPath;
    int health;

    public GameItem(String name,String imageIconPath) {
        this(name,imageIconPath,100);
    }

    public GameItem(String name, String imageIconPath, int health){
        this.name = name;
        this.health = health;
        this.imageIconPath = imageIconPath;
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

    public String getImageIconPath()
    {
        return imageIconPath;
    }

    public int getHealth()
    {
        return health;
    }
}
