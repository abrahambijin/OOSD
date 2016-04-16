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

    private PlayGround playGround = new PlayGround();
    private PlayerStatus rightPanel = new PlayerStatus();
    private JPanel game = new JPanel();
    private JPanel leftPanel = new JPanel();

    private int row = 10, col = 10;
    private Game warZone;
    private GameItem item;


    public GameGUI()
    {
        super("Game");
        game.setLayout(new BorderLayout());

        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(playGround);
        LabelField status = new LabelField("Status ");
        leftPanel.add(status, BorderLayout.SOUTH);
        playGround = new PlayGround();
        rightPanel = new PlayerStatus();
        JSplitPane splitPane =
                new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel,
                        rightPanel);
        splitPane.setResizeWeight(0.75);
        splitPane.setEnabled(false);
        game.add(splitPane, BorderLayout.CENTER);
        add(game);

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

//                //point cell = getPosition();
//                JButton cell = new CellPosition();
//                //System.out.println(position.getPosition());
//               // Point location = getLocationInput();
//                CellPosition pos = getPosition();
//                while(!warZone.addItemToBoard(player1,item,location))
//                {
//                    System.out.println("Incorrect position");
//                    System.out.print("Where would you like to place " +
//                            item.getName() + ":");
//                    location = getLocationInput();
//                }
            }
        }
        //displayBoard();


//        while(true)
//        {
//            Player currentPlayer = warZone.getNextPlayer();
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
    }



}
