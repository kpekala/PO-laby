package logic.simulation;

import logic.ThreadSimulation;
import logic.map.MapObserver;
import logic.map.WorldMap;
import logic.model.map.animal.Animal;
import logic.model.GameConfig;
import logic.model.map.Grass;
import logic.model.Vector2d;
import ui.game.GamePresenter;
import ui.model.AnimalModel;
import ui.model.Jungle;
import ui.model.MapModel;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Simulation extends ThreadSimulation implements MapObserver {
    private ArrayList<Animal> animals;
    private ArrayList<Grass> grasses;

    private WorldMap map;
    private GamePresenter presenter;
    private GameConfig gameConfig;
    private Jungle jungle;

    public Simulation(WorldMap map, GamePresenter presenter, int index) {
        super(index);
        this.map = map;
        this.presenter = presenter;
        this.gameConfig = presenter.getGameConfig();
        this.jungle = new Jungle(this.gameConfig);
        animals = new ArrayList<>();
        grasses = new ArrayList<>();
        map.attachObserver(this);
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
        removeDeadAnimals();
        for(Animal animal: animals){
            animal.updateEnergy(-gameConfig.getMoveEnergy());
            animal.changeDirection();
            animal.move();
        }
        map.processEating();
        addGrass();
        presenter.onMapUpdate(index, new MapModel(getAnimalModels(), getGrassModels()));
    }


    private void addGrass() {
        if(grasses.size() >= gameConfig.getHeight() * gameConfig.getWidth() - 2)
            return;
        RandomUtils randomUtils = new RandomUtils();
        Random rand = randomUtils.generator;
        //Na dżungli
        Grass jungleGrass = new Grass(randomUtils.randomPositionOnRect(jungle.getLowerLeft(), jungle.getUpperRight()));
        grasses.add(jungleGrass);
        map.placeGrass(jungleGrass);
        //Poza dzunglą
        int mapPart = randomUtils.generator.nextInt(4);
        Vector2d pos =  switch (mapPart){
            case 0 -> new Vector2d(
                    rand.nextInt(map.getWidth()),
                    RandomUtils.intRange(jungle.getUpperRight().y, map.getHeight()));
            case 1 -> new Vector2d(
                    RandomUtils.intRange(jungle.getUpperRight().x, map.getWidth()),
                    rand.nextInt(map.getHeight()));
            case 2 -> new Vector2d(
                    rand.nextInt(map.getWidth()),
                    rand.nextInt(jungle.getLowerLeft().y));
            case 3 -> new Vector2d(
                    rand.nextInt(jungle.getLowerLeft().x),
                    rand.nextInt(map.getHeight()));
            default -> throw new IllegalStateException("Unexpected value: " + mapPart);
        };
        Grass mapGrass = new Grass(pos);
        grasses.add(mapGrass);
        map.placeGrass(mapGrass);
    }

    private void removeDeadAnimals(){
        ArrayList<Animal> deadAnimals = new ArrayList<>();
        for(Animal animal: animals){
            if(animal.getEnergy() <= 0)
                deadAnimals.add(animal);
        }
        for(Animal animal: deadAnimals){
            animals.remove(animal);
        }
    }

    public ArrayList<AnimalModel> getAnimalModels() {
        ArrayList<AnimalModel> animalModels = new ArrayList<>();
        for (Animal animal : animals) {
            animalModels.add(new AnimalModel(animal));
        }
        return animalModels;
    }

    public Vector2d[] getGrassModels() {
        return grasses.stream().map(Grass::getPosition).toArray(Vector2d[]::new);
    }


    @Override
    public void onGrassRemoved(Grass grass) {
        grasses.remove(grass);
    }
}
