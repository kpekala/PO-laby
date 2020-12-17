package logic.simulation;

import logic.ThreadSimulation;
import logic.map.WorldMap;
import logic.model.map.animal.Animal;
import logic.model.GameConfig;
import logic.model.map.Grass;
import logic.model.Vector2d;
import ui.game.GamePresenter;
import ui.model.AnimalModel;
import ui.model.MapModel;
import utils.RandomUtils;

import java.util.ArrayList;

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
        animals = new ArrayList<>();
        grasses = new ArrayList<>();
        generateMapElements();
    }

    private void generateMapElements() {
        RandomUtils randomUtils = new RandomUtils();
        GameConfig config = presenter.getGameConfig();
        for(int i=0; i<config.getAnimalsNumber(); i++){
            Vector2d pos = randomUtils.randomPosition(new Vector2d(config.getWidth(), config.getHeight()));
            Animal animal = new Animal(map,pos,config.getStartEnergy());
            animals.add(animal);
            map.place(animal);
        }
    }

    @Override
    protected void processDay(){
        for(Animal animal: animals){
            animal.changeDirection();
            animal.move();
        }
        presenter.onMapUpdate(index, new MapModel(getAnimalModels()));
    }

    public ArrayList<AnimalModel> getAnimalModels() {
        ArrayList<AnimalModel> animalModels = new ArrayList<>();
        for (Animal animal : animals) {
            animalModels.add(new AnimalModel(animal));
        }
        return animalModels;
    }

}
