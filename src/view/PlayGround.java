package View;

import Utility.Position;
import Utility.ButtonStatus;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ankurdabral on 12/04/2016.
 * view to create the battel where unit will be placed and actual game will played
 */
public class PlayGround extends JPanel
{
    private int size;
    private Cell cell[][];


    public PlayGround(int boardSize, GameGUI view)
    {

        size = boardSize;

        this.setLayout(new GridLayout(size, size));
        // set user defined size of board
        cell = new Cell[size][size];
        initialise(view);
    }

    private void initialise(GameGUI view)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                cell[i][j] = new Cell(i, j);
                cell[i][j].setActionController(ButtonStatus.INITIAL_PLACING,
                        view);
                cell[i][j]
                        .setBorder(BorderFactory.createLineBorder(Color.black));
                this.add(cell[i][j]);

            }
        }
    }

    public void disableButtons(ArrayList<Position> exceptionsList,
                               Color buttonColor)
    { //enable/disable board cell according to game play
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (exceptionsList.contains(new Position(i, j)))
                { //enables board cell
                    cell[i][j].setEnabled(true);
                    cell[i][j].setBorder(
                            BorderFactory.createLineBorder(buttonColor, 1));
                }
                else
                { //default disable cells
                    cell[i][j].setEnabled(false);
                    cell[i][j].setOpaque(false);
                    cell[i][j].setBorder(
                            BorderFactory.createLineBorder(Color.lightGray));
                    cell[i][j].setDisabledIcon(null);
                }
            }
        }
    }

    public void setButtonImage(Position location, String path)
    {   //set images of unit on board cell
        Image buttonImage = getScaledImage(location, path);
        cell[location.getXCoordinate()][location.getYCoordinate()]
                .setIcon(new ImageIcon(buttonImage));
    }

    public void resetButtonActionListener(ButtonStatus status, GameGUI view)
    {
        //change actionlistned on cells
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
            {
                cell[i][j].setActionController(status,view);
            }
    }

    public void moveItem(Position initialPosition, Position finalPosition,
                         String imagePath)
    { // move item to different position/cell
        setButtonImage(initialPosition, null);
        setButtonImage(finalPosition, imagePath);
    }

    public void setDisabledButtonIcon(Position location, String path)
    {
        Image buttonImage = getScaledImage(location, path);

        cell[location.getXCoordinate()][location.getYCoordinate()]
                .setDisabledIcon(new ImageIcon(buttonImage));
    }

    private Image getScaledImage(Position location, String path)
    {
        int imageWidth =
                cell[location.getXCoordinate()][location.getYCoordinate()]
                        .getWidth() * 2 / 3;
        int imageHeight =
                cell[location.getXCoordinate()][location.getYCoordinate()]
                        .getHeight() * 3 / 4;

        return new ImageIcon(path).getImage()
                .getScaledInstance(imageWidth, imageHeight,
                        Image.SCALE_DEFAULT);
    }

    public void reset()
    {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                setButtonImage(new Position(i, j), null);
    }

}


