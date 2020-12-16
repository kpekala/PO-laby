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

    private int width;
    private int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        animals = new HashMap<>();
        grassElements = new HashMap<>();
    }

    @Override
    public void place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if(animals.get(pos) == null)
            animals.put(pos, new ArrayList<>());
        animals.get(pos).add(animal);
    }

    public void remove(Animal animal){
        Vector2d pos = animal.getPosition();
        if(animals.get(pos) == null)
            return;
        animals.get(pos).remove(animal);
        if(animals.get(pos).size() == 0)
            animals.remove(pos);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null && animals.get(position).size() > 0;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
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
        remove(animal);
        place(animal);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
