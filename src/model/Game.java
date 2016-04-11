package model;

import java.util.Scanner;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Game {

    private Board board;
    private BasePlayer playerOne;
    private Player playerTwo;

    public Game(Board board) {

        this.board = board;
        initializeGame();
        placePlayersOnBoard(new Player[]{playerOne, playerTwo});
    }

    private void initializeGame() {

        System.out.println("Player One will defend the base");
        askName(1);
        String teamName = getTeamName();

        Jet jet = new Jet(new Point(0,0), 3, new Bomb(), new Mg17());
        Army army = new Army(new Point(6,6), 1, new Pistol(), new Ak47());
        Tank tank = new Tank(new Point(6,6), 2,new Cannon(), new MachineGun());
        Tower tower = new Tower(new Point(9,9));
        Base base = new Base(new Point(0,0), 500);

        playerOne = new BasePlayer(teamName, tank, tower, base);
        askName(2);
        teamName = getTeamName();
        playerTwo = new Player(teamName,jet, army);
    }

    private void askName(int number) {
        System.out.println("Player" +  Integer.toString(number) + ",please select your team name:");
    }

    private String getTeamName() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    private void placePlayersOnBoard(Player [] players) {

        for(int i = 0; i < players.length ; i++) populateGameItems(players[i].getItems());

    }

    private void populateGameItems(GameItem [] items){

        for(int i = 0; i < items.length ; i++) board.placeGameItem(items[i]);
    }

}
