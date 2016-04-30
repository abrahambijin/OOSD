package view;

import controller.PlayButtonController;
import controller.PlayerNameInputController;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Bijin on 30-Apr-16.
 */
public class SettingsScreen extends JFrame
{
    private ArrayList<InputLabelTextField> players;
    private JComboBox<String> boardSize;
    JButton startButton;

    public SettingsScreen()
    {
        JLabel header = new JLabel("Game Settings", SwingConstants.CENTER);
        header.setOpaque(false);
        header.setForeground(Color.white);
        header.setFont(new Font("Arial", Font.BOLD, 20));

        players = new ArrayList<>();
        for (int i = 0; i < Game.getNO_OF_PLAYERS(); i++)
        {
            InputLabelTextField playerName = new InputLabelTextField("Player " +
                    "" + i);
            playerName.addDocumentListener(new PlayerNameInputController(this));
            players.add(playerName);
        }

        String[] sizeValue = {"Small", "Medium", "Large"};
        boardSize = new JComboBox<>(sizeValue);
        boardSize.setSelectedIndex(0);
        JLabel boardSizeHeading = new JLabel("Select Board Size: ");
        boardSizeHeading.setForeground(Color.white);
        boardSizeHeading.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel boardSizePanel = new JPanel(new FlowLayout());
        boardSizePanel.setBackground(new Color(61, 61, 61));
        boardSizePanel.add(boardSizeHeading);
        boardSizePanel.add(boardSize);
        boardSizePanel.setOpaque(false);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);

        startButton = new JButton("Play Game");
        startButton.addActionListener(new PlayButtonController(this));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(startButton);
        buttonPanel.add(cancelButton);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(header);
        for (InputLabelTextField inputLabelTextField : players)
            panel.add(inputLabelTextField);
        panel.add(boardSizePanel);
        panel.setOpaque(false);

        JLabel background = new JLabel(new ImageIcon("Images/gameLogo2.jpg"));
        background.setLayout(new BorderLayout());
        background.add(panel);
        background.add(buttonPanel,BorderLayout.SOUTH);

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
        return ((boardSize.getSelectedItem()).equals("Small")) ? 10 :
                ((boardSize.getSelectedItem()).equals("Medium")) ? 15 : 20;
    }

    public ArrayList<String> getNames()
    {
        ArrayList<String> playerNames = new ArrayList<>();
        for (InputLabelTextField inputLabelTextField : players)
            playerNames.add(inputLabelTextField.getTextField());
        return playerNames;
    }
}
