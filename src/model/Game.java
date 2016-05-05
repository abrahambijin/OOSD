package Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Game
{
    private static final int NO_OF_PLAYERS = 2;
    private Board board;
    private ArrayList<Player> players;
    private int currentPlayerIndex;

    public Game(ArrayList<String> teamNames, int boardSize)
    {
        this.board = new Board(boardSize);
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
                                  Position preferredLocation)
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

    public GameItem getItem(Position location)
    {
        return board.getItem(location);
    }

    public int getBOARD_SIZE()
    {
        return board.getBOARD_SIZE();
    }

    public ArrayList<Position> possiblePointToPlaceItems()
    {
        if (getCurrentPlayer() instanceof PlayerOne)
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

    public ArrayList<Position> getPossibleMovePoints(GameItem item)
    {
        if (item instanceof Unit)
        {
            ArrayList<Position> possibleMovePositions = new ArrayList<>();
            HashMap<Position, ArrayList<Position>> positions =
                    ((Unit) item).possibleMovePositions();

            positions.values().forEach(possibleMovePositions::addAll);

            if (item instanceof Tower)
                return possibleMovePositions;

            return board.filterMovePositions(positions);
        }
        return null;
    }

    public boolean isTroopOfCurrentPlayer(Position location)
    {
        return (players.get(currentPlayerIndex).getItemLocations()
                .contains(location));
    }

    public boolean move(Position currentLocation, Position newLocation)
    {
        boolean success = false;
        ArrayList<Position> possibleMoveLocations =
                getPossibleMovePoints(board.getItem(currentLocation));
        if (possibleMoveLocations != null &&
                possibleMoveLocations.contains(newLocation))
            success = board.move(currentLocation, newLocation);
        return success;
    }

    public ArrayList<Position> getOccupiedBoardLocation()
    {
        ArrayList<Position> positionsOccupied = new ArrayList<>();
        for (Player player : players)
            positionsOccupied.addAll(player.getItemLocations());
        return positionsOccupied;
    }

}
