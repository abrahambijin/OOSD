package Model;


import java.io.Serializable;

/**
 * Created by Bijin on 14-Apr-16.
 */
public class Obstacles extends GameItem implements Serializable
{
    public Obstacles()
    {
        super("Obstacles", 50);
    }

    @Override
    public void getHit(int damage)
    {
        super.getHit(damage);
        super.setImageIconPath(
                "Images/GameItems/" + super.getName() + "-broken.png");
    }
}
