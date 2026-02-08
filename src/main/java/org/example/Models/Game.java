package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Strategies.BotPlayingStrategy.BotPlayingStrategy;

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



    private Game(int dimension, List<Player> players){
        this.players=players;
        this.board=new Board(dimension);
        this.gameState=GameState.IN_PROGRESS;
        this.nextPlayerIndex=0;
    }

    public void makeMove(){

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
            return null;
        }
    }

}
