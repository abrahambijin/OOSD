package view;

import model.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ankurdabral on 11/04/2016.
 */
public class CellPosition extends JButton{

    private Point position;


    public CellPosition(int xCoordinate, int yCoordinate){
        this.position = new Point(xCoordinate,yCoordinate);
        //this.setBorderPainted(false);
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setOpaque(true);
    }

    public Point getPosition() {
        return position;
    }


}
