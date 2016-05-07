package View;

import Model.Position;

import javax.swing.*;

/**
 * Created by ankurdabral on 11/04/2016.
 * to initialize cell position in board
 */

public class Cell extends JButton
{

    private Position position;

    public Cell(int xCoordinate, int yCoordinate)
    {
        this.position = new Position(xCoordinate, yCoordinate);
        this.setOpaque(false);
    }

    public Position getPosition()
    {
        return position;
    }


}
