package model;

import exceptions.ObjectAlreadyExistException;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Game
{
    private static final int NO_OF_PLAYERS = 2;
    private final int BOARD_SIZE = 10;
    private Board board;
    private ArrayList<Player> players;
    private int currentPlayerIndex;

    public Game(ArrayList<String> teamNames)
    {
        this.board = new Board(BOARD_SIZE);
        players = new ArrayList<>();
        initializeGame(teamNames);
        currentPlayerIndex = 0;
    }

    private void initializeGame(ArrayList<String> teamNames)
    {
        for (String teamName : teamNames)
        {
            players.add(Player.playerFactory(teamName));
        }
    }

    public boolean addItemToBoard(Player player, GameItem item,
                                  Point preferredLocation)
    {
        boolean success;
        if (player instanceof PlayerOne)
            success = board.placePlayerOneItem(item, preferredLocation);
        else
            success = board.placePlayerItem(item, preferredLocation);
        return success;
    }

    public static int getNO_OF_PLAYERS()
    {
        return NO_OF_PLAYERS;
    }

    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public GameItem getItem(Point location)
    {
        return board.getItem(location);
    }

    public int getBOARD_SIZE()
    {
        return BOARD_SIZE;
    }

    public ArrayList<Point> possiblePointToPlaceItems(Player player)
    {
        if (player instanceof PlayerOne)
            return board.possiblePointsToPlacePlayerOneItem();
        else
            return board.possiblePointsToPlacePlayerItem();
    }

    public void nextPlayer()
    {
        currentPlayerIndex++;
        if (currentPlayerIndex == NO_OF_PLAYERS)
            currentPlayerIndex = 0;
    }
    public Player getCurrentPlayer()
    {
        return players.get(currentPlayerIndex);
    }

    public ArrayList<Point> getPossibleMovePoints(GameItem item)
    {
        if (item instanceof Troop)
        {
            ArrayList<Point> possibleMovePositions =
                    ((Troop) item).possibleMovePositions();
            if (item instanceof Tower)
                return possibleMovePositions;

            return board.filterMovePositions(possibleMovePositions);
        } return null;
    }

    public boolean isTroopOfCurrentPlayer(Point location)
    {
        return (players.get(currentPlayerIndex).getItemLocations()
                .contains(location));
    }

    public boolean move(Point currentLocation, Point newLocation)
    {
        boolean success = false;
        ArrayList<Point> possibleMoveLocations =
                getPossibleMovePoints(board.getItem(currentLocation));
        if (possibleMoveLocations != null &&
                possibleMoveLocations.contains(newLocation))
            success = board.move(currentLocation, newLocation);
        return success;
    }

}
