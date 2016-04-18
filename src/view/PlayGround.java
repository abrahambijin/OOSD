package view;

import com.sun.javafx.image.BytePixelSetter;
import controller.CellButtonController;
import controller.InitialItemPlacingController;
import model.Game;
import model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class PlayGround extends JPanel
{
    private int size;
    private Cell cell [][];



    public PlayGround(Game game, GameGUI view)
    {
        size = game.getBOARD_SIZE();
        this.setLayout(new GridLayout(size, size));
        cell = new Cell[size][size];
        initialise(game, view);


    }

    private void initialise(Game game, GameGUI view)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                cell[i][j] = new Cell(i, j);
                cell[i][j]
                        .setBorder(BorderFactory.createLineBorder(Color.black));
                cell[i][j].addActionListener(
                        new InitialItemPlacingController(new Point(i, j),game,view));
//                cell[i][j].setEnabled(false);
                this.add(cell[i][j]);

            }
        }
    }

    public void disableButtons(ArrayList<Point> exceptionsList)
    {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                cell[i][j].setEnabled(exceptionsList.contains(new Point(i,j)));
    }

    public void setButtonImage(Point location, String path)
    {
        cell[location.getXCoordinate()][location.getYCoordinate()].setIcon
                (new ImageIcon(path));
    }

    public void resetButtonActionListener(ActionListener actionListener)
    {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
            {
                for(ActionListener listener : cell[i][j].getActionListeners())
                    cell[i][j].removeActionListener(listener);
                cell[i][j].addActionListener(actionListener);
            }
    }

}


