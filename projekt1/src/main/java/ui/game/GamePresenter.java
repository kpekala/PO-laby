package ui.game;

import logic.model.GameConfig;
import logic.Simulation;

public class GamePresenter {
    private final GameStage gameStage;

    private GameConfig gameConfig;
    private int simulationsNumber = 1;
    private Simulation simulation;

    public GamePresenter(GameStage gameStage) {
        this.gameStage = gameStage;
        this.simulation = new Simulation();
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public void startGame(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        if(!gameConfig.isSingleSimulation())
            simulationsNumber = 2;
        for(int i=0; i<simulationsNumber; i++){
            gameStage.getGameFragment(i).init(gameConfig);
            gameStage.getMenuFragment(i).init(gameConfig);
        }
    }

}

