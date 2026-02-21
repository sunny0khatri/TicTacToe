package org.example.Models;

import org.example.Strategies.BotPlayingStrategy.BotPlayingStrategy;
import org.example.factory.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel){
        super(name,symbol);
        this.botDifficultyLevel=botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        botPlayingStrategy= BotPlayingStrategyFactory.getPlayingStrategy(botDifficultyLevel);
        return botPlayingStrategy.makeMove(board,this);
    }
}
