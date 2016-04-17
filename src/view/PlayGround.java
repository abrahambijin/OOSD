package view;

import controller.CellButtonController;
import model.Game;
import model.Point;

import javax.swing.*;
import java.awt.*;
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
    //cell[2][3].setBackground(Color.red);

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
                        new CellButtonController(new Point(i, j),game,view));
                cell[i][j].setEnabled(false);
                this.add(cell[i][j]);

            }
        }
        cell[5][3].setIcon(new ImageIcon("Images/Tank.png"));
        cell[5][3].setEnabled(true);
        cell[3][9].setIcon(new ImageIcon("Images/Army.png"));
        cell[8][1].setIcon(new ImageIcon("Images/Base.png"));
        cell[6][1].setIcon(new ImageIcon("Images/Tower.png"));
        cell[6][1].setEnabled(true);
        cell[0][8].setIcon(new ImageIcon("Images/Jet.png"));
    }

    public void disableButtons(ArrayList<Point> exceptionsList)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if(!exceptionsList.contains(new Point(i,j)))
                {
                    cell[i][j].setEnabled(false);
                }

            }
        }
    }

    public void setButtonImage(Point location, String path)
    {
        cell[location.getXCoordinate()][location.getYCoordinate()].setIcon
                (new ImageIcon(path));
    }

}


