package org.example.Controller;

import org.example.Models.*;
import org.example.exceptions.InvalidMoveException;

import java.util.List;

public class GameController {
    //startGame, makeMove, getGameStatus, getWinner


    public Game startGame(int dimension, List<Player> players){
        Game game=Game.getBuilder()
                      .setDimension(dimension)
                      .setPlayers(players)
                      .build();
        return game;
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        Player winner=game.getWinner();
        if(winner==null)
            throw new RuntimeException("No Winner found ");
        return winner;
    }


    public void getBoard(Game game){
        game.displayBoard();
    }
}
