package view;

import model.Position;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ankurdabral on 11/04/2016.
 */
public class Cell extends JButton{

    private Position position;


    public Cell(int xCoordinate, int yCoordinate){
        this.position = new Position(xCoordinate,yCoordinate);
        //this.setBorderPainted(false);
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.white);
        //this.setBackground(new Color(0,0,0,50));
        this.setOpaque(false);
    }

    public Position getPosition() {
        return position;
    }


}
