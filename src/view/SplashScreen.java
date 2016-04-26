package view;

import model.Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SplashScreen extends JWindow
{
    private ArrayList<String> playerNames = new ArrayList<>();
    JProgressBar progressBar;


    public SplashScreen(ImageIcon imageIcon)
    {
        this.getContentPane().setLayout(new BorderLayout());
        JLabel label = new JLabel(imageIcon);
        progressBar = new JProgressBar(0, 100);
        //        label.setIcon(imageIcon);
        JLabel text = new JLabel("Initialising.....");
        this.getContentPane().add(label);
        this.getContentPane().add(text, BorderLayout.SOUTH);
        this.pack();
    }


    public ArrayList<String> getNames()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        int players = Game.getNO_OF_PLAYERS();

        for (int j = 0; j < players; j++)
        {
            String name;
            name = JOptionPane.showInputDialog(null,
                    "Enter Player " + (j + 1) + " Team Name:",
                    ("Player " + (j + 1)), JOptionPane.QUESTION_MESSAGE);
            if (name == null || name.isEmpty())
                System.exit(0);
            else
                playerNames.add(name);
        }
        return playerNames;
    }

    public int getBoardSize(){
        String[] values = {"Small","Medium","Large"};

        Object selected = JOptionPane.showInputDialog(null, "Specify size of the board", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
        if ( selected == null ){
            System.exit(0);
        }
        String selectedString = selected.toString();
        return (selectedString.equals("Small"))? 10:(selectedString.equals("Medium"))? 15:20;
    }

}