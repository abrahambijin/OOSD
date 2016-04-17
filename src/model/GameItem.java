package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public abstract class GameItem  {

    private String name;
    private Point position;
    private String imageIconPath;
    int health;

    public GameItem(String name) {
        this(name,100);
    }

    public GameItem(String name, int health){
        this.name = name;
        this.health = health;
        this.imageIconPath = "Images/"+name+".png";
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

    protected void setImageIconPath(String imageIconPath)
    {
        this.imageIconPath = imageIconPath;
    }
}
