package view;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow
{
    public SplashScreen()
    {
        ImageIcon imageIcon = new ImageIcon("Images/warzone.jpg");
        this.getContentPane().setLayout(new BorderLayout());
        JLabel label = new JLabel();
        label.setIcon(imageIcon);
        this.getContentPane().add(label);
        this.pack();
    }
}