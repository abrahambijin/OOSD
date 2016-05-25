package Model;

import Settings.GameSettings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Game
{
    private Board board;
    private ArrayList<Player> players;
    private int currentPlayerIndex;

    public Game(ArrayList<String> teamNames, int boardSize, int noOfUnits)
    {
        this.board = new Board(boardSize);
        players = new ArrayList<>();
        initializeGame(teamNames, noOfUnits);
        currentPlayerIndex = 0;
    }

    private void initializeGame(ArrayList<String> teamNames, int noOfUnits)
    {
        for (String teamName : teamNames)
        {
            players.add(Player.playerFactory(teamName, noOfUnits));
        }
    }

    public boolean addItemToBoard(Player player, GameItem item,
                                  Position preferredLocation)
    {
        boolean success;
        success = board.placePlayerUnit(item, preferredLocation,
                player.isPlayerOne());
        return success;
    }


    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    public GameItem getItem(Position location)
    {
        return board.getUnit(location);
    }

    public int getBOARD_SIZE()
    {
        return board.getBOARD_SIZE();
    }

    public ArrayList<Position> possiblePointToPlaceItems()
    {
        return board.possiblePositionsToPlacePlayerUnits(
                getCurrentPlayer().isPlayerOne());
    }

    public void nextPlayer()
    {
        currentPlayerIndex++;
        if (currentPlayerIndex == GameSettings.NO_OF_PLAYERS)
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

    public void addObstacles()
    {
        board.addObstacles();
    }

    public boolean isUnitOfCurrentPlayer(Position location)
    {
        return (players.get(currentPlayerIndex).getItemLocations()
                .contains(location));
    }

    public boolean move(Position currentLocation, Position newLocation)
    {
        boolean success = false;
        ArrayList<Position> possibleMoveLocations =
                getPossibleMovePoints(board.getUnit(currentLocation));
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

    public ArrayList<Position> getPossibleShootingOptions(Position itemLocation,
                                                          String weaponName)
    {
        GameItem item = getItem(itemLocation);
        if (item instanceof Unit)
        {
            HashMap<Position, ArrayList<Position>> map =
                    ((Unit) item).getWeaponRange(weaponName);

            ArrayList<Position> possiblePositions = new ArrayList<>();

            for (ArrayList<Position> points : map.values())
                for (Position candidatePosition : points)
                {
                    if (board.isPositionOnBoard(candidatePosition) &&
                            !isUnitOfCurrentPlayer(candidatePosition))
                        possiblePositions.add(candidatePosition);
                }
            return possiblePositions;
        }
        return null;
    }

    public boolean hit(Position itemLocation, Position targetLocation,
                       String weaponName)
    {
        boolean success = false;

        if (isUnitOfCurrentPlayer(itemLocation) &&
                !isUnitOfCurrentPlayer(targetLocation))
        {
            success = board.hit(itemLocation, targetLocation, weaponName);

            if (success)
                players.forEach(Player::updateItemList);
        }

        return success;
    }

    public boolean checkGameStatus()
    {
        boolean isActive = board.isBaseActive();

        if (isActive)
        {
            int activePlayers = 0;
            for(Player player : players)
            {
                if (player.isAlive())
                    activePlayers++;
            }
            isActive = activePlayers > 1;
        }
        return isActive;
    }
}