package mainGameGUI;

import controller.StartGameButtonController;
import model.Game;
import view.GameGUI;
import view.SplashScreen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ankurdabral on 15/04/2016.
 */
public class MainGameGUI
{
    StartGameButtonController startGame;

    public static void main(String[] arg)
    {
        JWindow window = new JWindow();
        window.getContentPane().setLayout(new BorderLayout());
        window.getContentPane().add(
                new JLabel(new ImageIcon("Images/warzone.jpg")));
        //window.setBounds(400, 200, 400, 200);
        window.setSize(530,300);
        window.setLocationRelativeTo(null);
        JLabel text = new JLabel("Initialising.....");
        window.getContentPane().add(text, BorderLayout.SOUTH);
        window.setVisible(true);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        //Game game = new Game();

        //ImageIcon imageIcon = new ImageIcon("Images/warzone.jpg");
        SplashScreen splashScreen = new SplashScreen();
        //splashScreen.setSize(700,500);
        splashScreen.setLocationRelativeTo(null);
        splashScreen.setVisible(true);
        splashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Game game = new Game(splashScreen.getStartGame().getNames(),splashScreen.getStartGame().getBoard());
        //splashScreen.setVisible(false);

//        GameGUI gui = new GameGUI(game);
//        gui.setSize(1400, 700);
//        gui.setLocationRelativeTo(null);
//        gui.setVisible(true);
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
