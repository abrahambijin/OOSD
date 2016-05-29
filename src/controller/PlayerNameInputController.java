package Controller;


import SplashScreen.SettingsScreen;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * This class implements a document listener and a list listener for a panel
 * with a button. It changes the status of a button based on the user inputs.
 */
public class PlayerNameInputController implements DocumentListener
{

    private SettingsScreen screen;

    public PlayerNameInputController(SettingsScreen screen)
    {
        this.screen = screen;
    }


    @Override
    public void insertUpdate(DocumentEvent e)
    {
        screen.setButtonActive();// Trying to set a button active
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        screen.setButtonActive();// Trying to set a button inactive
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {

    }
}
