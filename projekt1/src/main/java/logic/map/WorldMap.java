package logic.map;

import logic.model.map.Grass;
import logic.model.map.animal.Animal;
import logic.model.Vector2d;
import ui.model.AnimalModel;
import ui.model.MapModel;

import javax.swing.*;
import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.HashMap;

public class WorldMap implements IWorldMap {

    private HashMap<Vector2d, ArrayList<Animal>> animals;
    private HashMap<Vector2d, Grass> grassElements;
    private ArrayList<Vector2d> eatingPlaces;
    private MapObserver mapObserver;

    private int width;
    private int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        animals = new HashMap<>();
        grassElements = new HashMap<>();
        eatingPlaces = new ArrayList<>();
    }

    public void attachObserver(MapObserver mapObserver){
        this.mapObserver = mapObserver;
    }

    @Override
    public void place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if(animals.get(pos) == null)
            animals.put(pos, new ArrayList<>());
        animals.get(pos).add(animal);
        if(grassElements.containsKey(pos))
            eatingPlaces.add(pos);
    }

    @Override
    public void placeGrass(Grass grass) {
        if (grassElements.containsKey(grass.getPosition()))
            return;
        grassElements.put(grass.getPosition(),grass);
        if(animals.containsKey(grass.getPosition()))
            eatingPlaces.add(grass.getPosition());
    }

    public void remove(Animal animal,Vector2d oldPosition){
        if(animals.get(oldPosition) == null){
            System.out.println("Auć!");
            return;
        }
        if(!animals.get(oldPosition).contains(animal)){
            System.out.println(":)");
        }
        animals.get(oldPosition).remove(animal);
        if(animals.get(oldPosition).size() == 0)
            animals.remove(oldPosition);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null && animals.get(position).size() > 0;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }

    @Override
    public void processEating() {
        for(Vector2d place: eatingPlaces){
            if(!isOccupied(place) || !grassElements.containsKey(place))
                continue;
            int maxEnergy = 0;
            ArrayList<Animal> bestAnimals = new ArrayList<>();
            Grass grass = grassElements.get(place);
            for(Animal animal: animals.get(place))
                if(maxEnergy < animal.getEnergy())
                    maxEnergy = animal.getEnergy();

            for(Animal animal: animals.get(place))
                if(animal.getEnergy() == maxEnergy)
                    bestAnimals.add(animal);

            int energyPerAnimal = 10 / bestAnimals.size();
            for(Animal animal: bestAnimals)
                animal.updateEnergy(energyPerAnimal);

            //Usuwanie zjedzonej trawy
            grassElements.remove(place);
            mapObserver.onGrassRemoved(grass);
        }
        eatingPlaces.clear();
    }

    public ArrayList<AnimalModel> getAnimalModels(){
        ArrayList<AnimalModel> animalModels = new ArrayList<>();
        for(Vector2d pos : animals.keySet()){
            //Sortowanie potrzebne!
            if(isOccupied(pos))
                animalModels.add(new AnimalModel(animals.get(pos).get(0)));
        }
        return animalModels;
    }

    public void onAnimalMoved(Animal animal, Vector2d oldPosition, Vector2d newPosition){
        remove(animal, oldPosition);
        place(animal);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
