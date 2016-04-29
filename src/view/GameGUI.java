package view;


import controller.StartGameButtonController;
import model.Game;
import java.awt.*;
import javax.swing.*;

/**
 * Created by ankurdabral on 11/04/2016.
 */
public class GameGUI extends JFrame
{

    private PlayGround playGround;
    private PlayerStatus playerStatus;
    private LabelField status;
    private SplashScreen splashScreen;


    public GameGUI(Game game)
    {

        super("WarZone");
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        playGround = new PlayGround(game, this);
        playerStatus = new PlayerStatus(game,this);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setOpaque(false);
        leftPanel.add(playGround);
        status = new LabelField("Status ");
        //status.setBackground(Color.yellow);
        setStatus(
                game.getCurrentPlayer().getName() + ", where would you like to" +
                        " place the Base?");
        leftPanel.add(status, BorderLayout.SOUTH);

        JSplitPane splitPane =
                new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel,
                        playerStatus);
        splitPane.setResizeWeight(0.75);
        splitPane.setEnabled(false);
        splitPane.setOpaque(false);
        gamePanel.setBackground(new Color(65,65,65));
        gamePanel.add(splitPane, BorderLayout.CENTER);
        add(gamePanel);

    }

    public PlayGround getPlayGround()
    {
        return playGround;
    }

    public PlayerStatus getPlayerStatus()
    {
        return playerStatus;
    }

    public void setStatus(String status)
    {
        this.status.setValue(status);
    }

    public SplashScreen getSplashScreen() {return splashScreen; }
}
