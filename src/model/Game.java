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
    }

    public void initializeGame(String teamNamePlayerOne, String teamNamePlayerTwo) {

        Weapon Ak47 = new Weapon(2,15,true,true);
        Weapon bomb = new Weapon(1,25,true,false);
        Weapon cannon = new Weapon(2,15,false,true);

        Jet jet = new Jet(new Point(0,0), 3, bomb, new Mg17());
        Army army = new Army(new Point(6,6), 1, new Pistol(), Ak47);
        Tank tank = new Tank(new Point(6,6), 2, cannon, new MachineGun());
        Tower tower = new Tower(new Point(9,9));
        Base base = new Base(new Point(0,0), 500);

        playerOne = new BasePlayer(teamNamePlayerOne, tank, tower, base);
        playerTwo = new Player(teamNamePlayerTwo,jet, army);

        placePlayersOnBoard(new Player[] {playerOne, playerTwo});
    }

    private void placePlayersOnBoard(Player [] players) {

        for(int i = 0; i < players.length ; i++) populateGameItems(players[i].getItems());

    }

    private void populateGameItems(GameItem [] items){

        for(int i = 0; i < items.length ; i++) board.placeGameItem(items[i]);
    }

}
