package controller;

import model.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class GetCellPositionController implements ActionListener {
   private Point location;

    public GetCellPositionController(Point location) {
        this.location = location;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(location);
    }
}
