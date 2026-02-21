package org.example.factory;

import org.example.Models.BotDifficultyLevel;
import org.example.Strategies.BotPlayingStrategy.BotPlayingStrategy;
import org.example.Strategies.BotPlayingStrategy.EasyBotPlayingStrategy;
import org.example.Strategies.BotPlayingStrategy.HardBotPlayingStrategy;
import org.example.Strategies.BotPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY))
            return new EasyBotPlayingStrategy();
        if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM))
            return new MediumBotPlayingStrategy();
        if(botDifficultyLevel.equals(BotDifficultyLevel.HARD))
            return new HardBotPlayingStrategy();
        return null;
    }
}
