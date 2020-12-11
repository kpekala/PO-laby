package ui.game;

import logic.model.GameConfig;
import logic.Simulation;

public class GamePresenter {
    private final GameStage gameStage;

    private GameConfig gameConfig;
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
        gameStage.getGameFragment().init(gameConfig);
    }

}

