package view;

import com.sun.deploy.uitoolkit.*;
import com.sun.deploy.uitoolkit.Window;
import controller.StartGameButtonController;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SplashScreen extends JFrame
{
    private ArrayList<String> playerNames = new ArrayList<>();
    JProgressBar progressBar;
    InputLabelTextField player1,player2;
    BoardSizeSelection boardSize;
    StartGameButtonController startGame;

    public SplashScreen()
    {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(60,60,60));
            JLabel label = new JLabel(new ImageIcon("Images/warzone.jpg"));
            label.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0,1));
            panel.setBackground(new Color(0,0,0,20));

        JLabel header = new JLabel("Game Settings", SwingConstants.CENTER);
            header.setOpaque(false);
            header.setForeground(Color.white);
            header.setFont(new Font("Arial",Font.BOLD,20));
        player1 = new InputLabelTextField("Player1");
        player2 = new InputLabelTextField("Player2");
        boardSize = new BoardSizeSelection();

        JPanel startGameButton = new JPanel();
            startGameButton.setOpaque(false);
            JButton startButton = new JButton("Start Game");
                startGame = new StartGameButtonController(this);
                startButton.addActionListener(startGame);
            JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            startGameButton.add(startButton);
            startGameButton.add(cancelButton);

        panel.add(header);
        panel.add(player1);
        panel.add(player2);
        panel.add(boardSize);
        panel.add(startGameButton);

        label.add(panel);
        progressBar = new JProgressBar(0, 100);

        //JLabel text = new JLabel("Initialising.....");

        this.getContentPane().add(label);
        //this.getContentPane().add(text, BorderLayout.SOUTH);
        this.pack();

    }

    public StartGameButtonController getStartGame() {
        return startGame;
    }

    public ArrayList<String> getNames(){
         playerNames.add(player1.getTextField());
         playerNames.add(player2.getTextField());
        return playerNames;
    }

    public int getBoardSize(){
        return ((boardSize.getSelectedItem()).equals("Small")) ? 10 :
               ((boardSize.getSelectedItem()).equals("Medium")) ? 15 : 20;
    }
}