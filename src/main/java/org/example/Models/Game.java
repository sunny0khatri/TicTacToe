package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Strategies.BotPlayingStrategy.BotPlayingStrategy;
import org.example.Strategies.WinningStrategy.ColumnWiseWinningStrategy;
import org.example.Strategies.WinningStrategy.DiagonalWiseWinningStrategy;
import org.example.Strategies.WinningStrategy.RowWiseWinningStrategy;
import org.example.Strategies.WinningStrategy.WinningStrategy;
import org.example.exceptions.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private BotPlayingStrategy botPlayingStrategy;
    private List<WinningStrategy> winningStrategies;



    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        this.players=players;
        this.board=new Board(dimension);
        this.gameState=GameState.IN_PROGRESS;
        this.nextPlayerIndex=0;
        this.winningStrategies=winningStrategies;
        this.moves=new ArrayList<>();
    }

    public void makeMove() throws InvalidMoveException{
        Player currentPlayer=players.get(nextPlayerIndex);
        Move currMove=currentPlayer.makeMove(board);

        if(!validateMove(currMove)){
            throw new InvalidMoveException("Chosen cell is either filled or row or columns is wrongly selected.");
        }
//        System.out.println("testing "+ currMove.getCell().getRow());
        int row=currMove.getCell().getRow();
        int col=currMove.getCell().getCol();

        //mark the move on board
        board.getCells().get(row).get(col).setPlayer(currentPlayer);
        board.getCells().get(row).get(col).setCellStatus(CellStatus.FILLED);
        moves.add(currMove);

        if(checkWinner(board,currMove)){
            this.winner=currentPlayer;
            this.gameState=GameState.ENDED;
        }
        else if(moves.size()== board.getDimension()* board.getDimension()){
            this.gameState=GameState.DRAW;
        }
        nextPlayerIndex=(nextPlayerIndex+1)% players.size();
    }

    private boolean checkWinner(Board board, Move move){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(board,move))
                return true;
        }
        return false;
    }

    private boolean validateMove(Move move){
//        System.out.println(move==null);
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        if(row<0 || row> board.getDimension() || col<0 || col> board.getDimension())
            return false;

        if(!board.getCells().get(row).get(col).isEmpty())
            return false;
        return true;
    }


    public void displayBoard(){
        this.board.displayBoard();
    }


    public static Builder getBuilder(){
        return new Builder();
    }


    @Getter
    public static class Builder{
        private List<Player> players;
        private int dimension;


        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Game build(){
            if(this.dimension<3)
                throw new RuntimeException("Dimension should be greater than 2");
            if(this.getPlayers()==null || this.getPlayers().size()<dimension-1)
                throw new RuntimeException("No. of players must be "+ (dimension-1));
            List<WinningStrategy> winningStrategies=new ArrayList<>();
            winningStrategies.add(new RowWiseWinningStrategy());
            winningStrategies.add(new ColumnWiseWinningStrategy());
            winningStrategies.add(new DiagonalWiseWinningStrategy());
            return new Game(dimension,players,winningStrategies);
        }
    }

}
