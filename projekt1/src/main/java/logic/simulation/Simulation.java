package logic.simulation;

import logic.ThreadSimulation;
import logic.map.WorldMap;
import logic.model.map.animal.Animal;
import logic.model.GameConfig;
import logic.model.map.Grass;
import logic.model.Vector2d;
import org.checkerframework.checker.units.qual.A;
import ui.game.GamePresenter;
import ui.model.MapModel;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Simulation extends ThreadSimulation {
    private ArrayList<Animal> animals;
    private ArrayList<Grass> grasses;

    private WorldMap map;
    private GamePresenter presenter;
    public Simulation(WorldMap map, GamePresenter presenter, int index) {
        super(index);
        this.map = map;
        this.presenter = presenter;
        generateMapElements();
    }

    private void generateMapElements() {
        RandomUtils randomUtils = new RandomUtils();
        GameConfig config = presenter.getGameConfig();
        for(int i=0; i<config.getAnimalsNumber(); i++){
            Vector2d pos = randomUtils.randomPosition(new Vector2d(config.getSizeX(), config.getSizeY()));
            Animal animal = new Animal(map,pos,10);
            animals.add(animal);
            map.place(animal);
        }
    }

    @Override
    protected void processDay(){
        moveAnimals();
        presenter.onMapUpdate(index, new MapModel(map.getAnimalModels()));
    }

    private void moveAnimals() {
        for(Animal animal: animals){
            animal.move();
        }
    }

}
