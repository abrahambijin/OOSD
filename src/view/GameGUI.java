package view;

import exceptions.ObjectAlreadyExistException;
import model.Game;
import model.GameItem;
import model.Player;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by ankurdabral on 11/04/2016.
 */
public class GameGUI extends JFrame
{

    private PlayGround playGround;
    private PlayerStatus playerStatus;


    public GameGUI(Game game)
    {
        super("Game");

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        playGround = new PlayGround(game, this);
        playerStatus = new PlayerStatus();

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(playGround);
        LabelField status = new LabelField("Status ");
        leftPanel.add(status, BorderLayout.SOUTH);

        JSplitPane splitPane =
                new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel,
                        playerStatus);
        splitPane.setResizeWeight(0.75);
        splitPane.setEnabled(false);
        gamePanel.add(splitPane, BorderLayout.CENTER);
        add(gamePanel);
    }
}

        // Add players team name


        //play

        //
        // set with player 1
        //        JOptionPane.showMessageDialog(null,
        //                "Player : " + player.get(0) + " will Go first", "Information",
        //                JOptionPane.INFORMATION_MESSAGE);

        //        for (Player player1 : game.getPlayers())
        //        {
        //            for (GameItem item : player1.getItems())
        //            {
        //                playerStatus.getTop().setPlayerName(player1);
        //
        //                JOptionPane.showMessageDialog(null,
        //                        "Click where would you like to place " +
        //                                item.getName() + ": ", player1.getName(),
        //                        JOptionPane.INFORMATION_MESSAGE);
        //
        //                //                //point cell = getPosition();
        //                //                JButton cell = new CellPosition();
        //                //                //System.out.println(position.getPosition());
        //                //               // Point location = getLocationInput();
        //                //                CellPosition pos = getPosition();
        //                //                while(!warZone.addItemToBoard(player1,item,location))
        //                //                {
        //                //                    System.out.println("Incorrect position");
        //                //                    System.out.print("Where would you like to place " +
        //                //                            item.getName() + ":");
        //                //                    location = getLocationInput();
        //                //                }
        //            }
        //        }
        //displayBoard();


        //        while(true)
        //        {
        //            Player currentPlayer = warZone.nextPlayer();
        //
        //            System.out.println(currentPlayer.getName()+": Select a Troop");
        //            JOptionPane.showMessageDialog(null,currentPlayer.getName()+" : Select a Troop",currentPlayer.getName(),JOptionPane.INFORMATION_MESSAGE);
        //            Point selectedPoint = getLocationInput();
        //            while(!warZone.isTroopOfCurrentPlayer(selectedPoint))
        //            {
        //                System.out.println("Incorrect selection");
        //                System.out.println(currentPlayer.getName()+": Select a Troop");
        //                selectedPoint = getLocationInput();
        //            }
        //            System.out.println("Where do you want to move "+warZone.getItem
        //                    (selectedPoint).getName());
        //            Point newLocation = getLocationInput();
        //            while(!warZone.move(selectedPoint,newLocation))
        //            {
        //                System.out.println("Incorrect selection");
        //                System.out.println("Where do you want to move "+warZone.getItem
        //                        (selectedPoint).getName());
        //                newLocation = getLocationInput();
        //            }
        //            System.out.println();
        //            //displayBoard();
        //        }


        //        public Point getLocation(){
        //        CellPosition
        //        }
