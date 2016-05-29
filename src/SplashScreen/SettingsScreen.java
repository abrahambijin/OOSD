package SplashScreen;

import Controller.PlayButtonController;
import Controller.PlayerNameInputController;
import Settings.GameSettings;
import Utility.CustomFonts;
import Utility.InputLabelTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Bijin on 30-Apr-16.
 *
 * first screen to set player names , size of board and number of pieces
 */
public class SettingsScreen extends JFrame
{
    private ArrayList<InputLabelTextField> players;
    private JComboBox<String> boardSize;
    private JComboBox<String> pecies;
    JButton startButton;

    public SettingsScreen()
    {
        JLabel header = new JLabel("Game Settings", SwingConstants.CENTER);
        header.setOpaque(false);
        header.setForeground(Color.white);
        header.setFont(CustomFonts.lifeCraft);

        //Input label fields for player names
        players = new ArrayList<>();
        for (int i = 0; i < GameSettings.NO_OF_PLAYERS; i++)
        {
            InputLabelTextField playerName = new InputLabelTextField("Player " +
                    "" + (i + 1));
            playerName.addDocumentListener(new PlayerNameInputController(this));
            players.add(playerName);
        }

        //selecting board size
        String[] sizeValue = {"Small", "Medium", "Large"};
        boardSize = new JComboBox<>(sizeValue);
        boardSize.setSelectedIndex(0);
        JLabel boardSizeHeading = new JLabel("Select Board Size");
        boardSizeHeading.setForeground(Color.white);
        boardSizeHeading.setFont(CustomFonts.droidSans);
        JPanel boardSizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
        boardSizePanel.setBackground(new Color(61, 61, 61));
        boardSizePanel.add(boardSizeHeading);
        boardSizePanel.add(boardSize);
        boardSizePanel.setOpaque(false);

      //setting number of pieces
        int limit = GameSettings.MAX_NO_OF_UNITS/GameSettings.INCREMENTS;
        String[] peciesValue = new String[limit];
        for(int i = 0,j=GameSettings.INCREMENTS; i<limit; i++,j+=GameSettings.INCREMENTS)
        {
            peciesValue[i]=j+"";
        }
        pecies = new JComboBox<>(peciesValue);
        pecies.setSelectedIndex(0);
        JLabel peciesHeading = new JLabel("Number Of Pecies");
        peciesHeading.setForeground(Color.white);
        peciesHeading.setFont(CustomFonts.droidSans);
        JPanel playerPeciesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
        playerPeciesPanel.setBackground(new Color(61, 61, 61));
        playerPeciesPanel.add(peciesHeading);
        playerPeciesPanel.add(pecies);
        playerPeciesPanel.setOpaque(false);

        //add start and cancel button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        startButton = new JButton("Play Game");
        startButton.addActionListener(new PlayButtonController(this));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> System.exit(0));

        //adding buttons
        buttonPanel.add(startButton);
        buttonPanel.add(cancelButton);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(header);
        for (InputLabelTextField inputLabelTextField : players)
            panel.add(inputLabelTextField);
        panel.add(playerPeciesPanel);
        panel.add(boardSizePanel);
        panel.setOpaque(false);

        //add backgroung image
        JLabel background = new JLabel(new ImageIcon("Images/gameLogo2.jpg"));
        background.setLayout(new BorderLayout());
        background.add(panel);
        background.add(buttonPanel, BorderLayout.SOUTH);

        this.add(background);
        this.setUndecorated(true);
        this.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        this.setVisible(true);
    }

    public void setButtonActive()
    {
        for (InputLabelTextField inputLabelTextField : players)
            if (inputLabelTextField.isEmpty())
            {
                startButton.setEnabled(false);
                return;
            }
        startButton.setEnabled(true);
    }

    public int getBoardSize()
    {
        return GameSettings.BoardSize
                .getBoardSize(boardSize.getSelectedItem().toString());
    }
    public int getPecies()
    {
        return GameSettings.getNoOfUnits(pecies.getSelectedItem().toString());
    }
    public ArrayList<String> getNames()
    {
        ArrayList<String> playerNames = new ArrayList<>();
        for (InputLabelTextField inputLabelTextField : players)
            playerNames.add(inputLabelTextField.getTextField());
        return playerNames;
    }
}
