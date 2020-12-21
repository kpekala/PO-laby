package ui.game;

import logic.map.WorldMap;
import logic.model.GameConfig;
import logic.model.map.animal.Animal;
import logic.simulation.Simulation;
import ui.model.MapModel;
import ui.model.StatisticsModel;

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
            gameStage.getStatisticsFragment(i).onStartGame(gameConfig);
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
        gameStage.getDetailsFragment().update();
    }

    public void onStatisticsUpdate(int index, StatisticsModel model){
        gameStage.getStatisticsFragment(index).update(model);
    }

    public void onCellClicked(int mapX, int mapY, int index) {
        simulations[index].onNewChosenAnimal(mapX,mapY);
    }

    public void showChosenAnimal(Animal animal, int index) {
        gameStage.getDetailsFragment().setChosenAnimal(animal);
        gameStage.getGameFragment(index).setChosenAnimal(animal);
    }
}

