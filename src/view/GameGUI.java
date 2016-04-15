package view;

import exceptions.ObjectAlreadyExistException;
import model.Game;
import model.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
//import controller.WindowDestroyer;
/**
 * Created by ankurdabral on 11/04/2016.
 */
public class GameGUI extends JFrame {

    private PlayGround leftPanel = new PlayGround();
    private PlayerStatus rightPanel = new PlayerStatus();
    private JPanel gameButtons = new JPanel();
    private int row =10,col= 10;
    private Game warZone;


    public GameGUI(){
        super("Game");
        gameButtons.setLayout(new BorderLayout());
        leftPanel = new PlayGround();
        rightPanel = new PlayerStatus();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
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

        for (int i =0; i< players; i++){
            player.add(JOptionPane.showInputDialog(null,"Enter Player "+ (i + 1)+ " Team Name:"));
        }
        try {
            warZone = Game.gameFactory(player);
        } catch (ObjectAlreadyExistException e) {
            JOptionPane.showMessageDialog(null,"Error - "+ e.getMessage());

            System.exit(0);
        }

        //play

        for (int i =0; i< players; i++) {

//            System.out.println(warZone);
            rightPanel.setPlayerName(warZone.getPlayers().get(i));

            JOptionPane.showMessageDialog(null,"Player "+i+" Colour");
        }

    }


}
