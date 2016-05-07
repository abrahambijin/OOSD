package View;


import Model.Game;

import java.awt.*;
import javax.swing.*;

/**
 * Created by ankurdabral on 11/04/2016.
 * GUI frame which comprises of various views of the game as stated below
 * playGround- comprise of 2-d array of cell
 * playerStatus- comprises of players itinerary and action buttons for player
 */
public class GameGUI extends JFrame
{

    private PlayGround playGround;
    private PlayerStatus playerStatus;
    private LabelField status;


    public GameGUI(Game game)
    {
        super("WarZone");
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        // creating objects of playGround and playerStatus view
        playGround = new PlayGround(game, this);
        playerStatus = new PlayerStatus(game, this);

        // panel to add playground and status of label at bottom
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setOpaque(false);
        leftPanel.add(playGround);
            // status to display game information
            status = new LabelField("Status ");
            setStatus(game.getCurrentPlayer().getName() +
                ", where would you like to" +
                " place the Base?");
        leftPanel.add(status, BorderLayout.SOUTH);

        // splitpane to add playGraound and playerStatus
        JSplitPane splitPane =
                new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel,
                        playerStatus);
        splitPane.setResizeWeight(0.75);
        splitPane.setEnabled(false);
        splitPane.setOpaque(false);
        gamePanel.setBackground(new Color(40, 40, 40));
        gamePanel.add(splitPane, BorderLayout.CENTER);
        add(gamePanel);
    }

    // to return playGround
    public PlayGround getPlayGround()
    {
        return playGround;
    }

    // to return playerStatus
    public PlayerStatus getPlayerStatus()
    {
        return playerStatus;
    }
    // to set status information of game
    public void setStatus(String status)
    {
        this.status.setValue(status);
    }

}
