package ui.game;

import logic.map.WorldMap;
import logic.model.GameConfig;
import logic.simulation.Simulation;
import ui.model.MapModel;

public class GamePresenter {
    private final GameStage gameStage;

    private GameConfig gameConfig;
    private int simulationsNumber = 1;
    private Simulation[] simulations;

    public GamePresenter(GameStage gameStage) {
        this.gameStage = gameStage;
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
            gameStage.getMenuFragment(i).onStartGame(gameConfig);
        }

        startSimulation();
    }

    private void startSimulation() {
        int factor = gameConfig.isSingleSimulation() ? 1 : 2;
        simulations = new Simulation[factor];
        for(int i=0; i<factor; i++){
            simulations[i] = new Simulation(new WorldMap(gameConfig, gameConfig.getWidth(), gameConfig.getHeight(), gameConfig.getPlantEnergy()),this, i);
            simulations[i].startGame();
        }
    }

    public void onStopGame(int index){
        simulations[index].stopGame();
    }

    public void onResumeGame(int index){
        simulations[index].resumeGame();
    }

    public void onAppStop(){
        for(Simulation simulation: simulations){
            simulation.finish();
        }
    }

    public void onMapUpdate(int index, MapModel mapModel){
        gameStage.getGameFragment(index).update(mapModel);
    }
}

