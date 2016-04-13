package model;

import exceptions.ObjectAlreadyExistException;

import java.util.ArrayList;
/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Game
{
    private final int BOARD_SIZE = 10;
    private static final int NO_OF_PLAYERS = 2;
    private Board board;
    private ArrayList<Player> players;
    private static int noOfGameObjects = 0;

    private Game(ArrayList<String> teamNames)
    {
        this.board = new Board(BOARD_SIZE);
        players = new ArrayList<>();
        initializeGame(teamNames);
    }

    private void initializeGame(ArrayList<String> teamNames)
    {
        for (String teamName : teamNames)
        {
            players.add(Player.playerFactory(teamName));
        }
    }

    public void placePlayersOnBoard()
    {
        for (Player player : players)
            for (GameItem item : player.getItems())
                board.placeGameItem(item);

    }

    public static int getNO_OF_PLAYERS()
    {
        return NO_OF_PLAYERS;
    }

    public static Game gameFactory(ArrayList<String> teamNames)
            throws ObjectAlreadyExistException
    {
        if (noOfGameObjects == 0)
        {
            noOfGameObjects++;
            return new Game(teamNames);
        }
        else
        {
            throw new ObjectAlreadyExistException(
                    "A game class already " + "exists");
        }
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public String getItemName(Point location)
    {
        return board.getItemName(location);
    }

    public int getBOARD_SIZE()
    {
        return BOARD_SIZE;
    }
}
