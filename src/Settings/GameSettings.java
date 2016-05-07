package Settings;

/**
 * Created by Bijin on 06-May-16.
 */
public final class GameSettings
{
    public static class BoardSize
    {
        private static final int small = 10;
        private static final int medium = 15;
        private static final int large = 20;

        public static int getBoardSize(String selection)
        {
            return (selection.equalsIgnoreCase("Small")) ? small :
                    ((selection.equalsIgnoreCase("Medium")) ? medium : large);
        }
    }

    public static final int NO_OF_PLAYERS = 2;
    public static final int MAX_NO_OF_UNITS = 8;
    public static final int INCREMENTS = 2;

    public static int getNoOfUnits(String selection)
    {
        for(int i = INCREMENTS; i<=MAX_NO_OF_UNITS; i+=INCREMENTS)
        {
            if(selection.equalsIgnoreCase(i+""))
                return i;
        }
        return INCREMENTS;
    }

}
