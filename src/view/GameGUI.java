package view;

import controller.GetCellPositionController;
import exceptions.ObjectAlreadyExistException;
import model.Game;
import model.GameItem;
import model.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 * Created by ankurdabral on 11/04/2016.
 */
public class GameGUI extends JFrame
{

    private PlayGround leftPanel = new PlayGround();
    private PlayerStatus rightPanel = new PlayerStatus();
    private JPanel gameButtons = new JPanel();
    private int row = 10, col = 10;
    private Game warZone;
    private GameItem item;


    public GameGUI()
    {
        super("Game");
        gameButtons.setLayout(new BorderLayout());
        leftPanel = new PlayGround();
        rightPanel = new PlayerStatus();
        JSplitPane splitPane =
                new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel,
                        rightPanel);
        splitPane.setResizeWeight(0.75);
        splitPane.setEnabled(false);
        gameButtons.add(splitPane, BorderLayout.CENTER);
        add(gameButtons);

        // Add players team name
        this.setSize(1400, 700);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //this.addWindowListener(new WindowDestroyer(this));
        this.setVisible(true);
        int players = Game.getNO_OF_PLAYERS();

        ArrayList<String> player = new ArrayList<>();

        for (int i = 0; i < players; i++)
        {
            player.add(JOptionPane.showInputDialog(null,
                    "Enter Player " + (i + 1) + " Team Name:","Player 1",JOptionPane.INFORMATION_MESSAGE));
        }
        try
        {
            warZone = Game.gameFactory(player);
        }
        catch (ObjectAlreadyExistException e)
        {
            JOptionPane.showMessageDialog(null, "Error - " + e.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);

            System.exit(0);
        }

        //play

//
        // set with player 1
        JOptionPane.showMessageDialog(null,"Player : "+player.get(0)+" will Go first","Information",JOptionPane.INFORMATION_MESSAGE);

        for(Player player1: warZone.getPlayers())
        {
            for (GameItem item : player1.getItems())
            {
                rightPanel.getTop().setPlayerName(player1);
                JOptionPane.showMessageDialog(null,"Click where would you like to place " + item.getName() + ": ",player1.getName(),JOptionPane.INFORMATION_MESSAGE);

                //point cell = getPosition();
                //System.out.println(position.getPosition());
//                Point location = getLocationInput();
//                while(!game.addItemToBoard(player,item,location))
//                {
//                    System.out.println("Incorrect position");
//                    System.out.print("Where would you like to place " +
//                            item.getName() + ":");
//                    location = getLocationInput();
//                }
            }
        }
        //displayBoard();


    }


}
