package controller;

import model.Point;
import view.CellPosition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class CellButtonController implements ActionListener {
   private Point location;

    public CellButtonController(Point location) {
        this.location = location;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //System.out.println(location);
        //new CellPosition(location.getXCoordinate(),location.getYCoordinate());



    }
}
