package Undo;

import Controller.*;
import Interfaces.AbstractPlayerPropertiesFactory;
import Interfaces.Weapon;
import Model.*;
import Settings.GameSettings;
import Settings.UnitsList;
import Utility.CustomFonts;
import Utility.PossiblePoints;
import View.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by mitulmanish on 28/05/2016.
 */
public class SaveGameState
{
    public static int COUNTER = 0;
    public static String SAVE_LOCATION =
            "undo" + Integer.toString(COUNTER) + ".txt";
    private ObjectMapper mapper = new ObjectMapper();

    public SaveGameState()
    {
        mapper.setVisibility(PropertyAccessor.ALL,
                JsonAutoDetect.Visibility.ANY);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
        mapper.registerSubtypes(Board.class, GameItem.class, Obstacles.class,
                Player.class, Tower.class, Unit.class, ItemInfo.class,
                ItemWeaponInfo.class, MoveStyle.class, PlayerStatus.class,
                PlayGround.class);
    }

    public boolean saveGame(GameController gameController)
    {
        if (COUNTER < 3)
        {
            COUNTER++;
        }
        else
            COUNTER = 1;

        SAVE_LOCATION = "undo" + Integer.toString(COUNTER) + ".txt";

        try
        {
            PrintWriter writer = new PrintWriter(SAVE_LOCATION);

            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            SaveObject saveObject = new SaveObject();

            saveObject.game = gameController.getGame();
            saveObject.view = gameController.getView();
            String json = ow.writeValueAsString(saveObject);
            writer.print(json);

            writer.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loadGame(GameController gameController, int stage)
    {
        SAVE_LOCATION = "undo" + Integer.toString(stage) + ".txt";
        try
        {
            Path path = Paths.get(SAVE_LOCATION);
            if (!Files.exists(path))
                return false;
            String json = new String(Files.readAllBytes(path));
            if (json.isEmpty())
                return false;
            SaveObject saveObject = mapper.readValue(json, SaveObject.class);
            gameController.setGame(saveObject.game);
            gameController.setView(saveObject.view);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }


}
