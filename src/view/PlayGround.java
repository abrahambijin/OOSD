package view;

import controller.CellButtonController;
import model.Game;
import model.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class PlayGround extends JPanel
{
    private int size;

    public PlayGround(Game game, GameGUI view)
    {
        size = game.getBOARD_SIZE();
        this.setLayout(new GridLayout(size, size));
        //this.setBackground(Color.blue);
        initialise(game, view);


    }
    //cell[2][3].setBackground(Color.red);

    private void initialise(Game game, GameGUI view)
    {
        Cell cell[][] = new Cell[size][size];
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

}


