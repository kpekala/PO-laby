package agh.cs.lab5;

import agh.cs.lab5.prev.IWorldMap;
import agh.cs.lab5.prev.MapVisualizer;
import agh.cs.lab5.prev.base.Animal;
import agh.cs.lab5.prev.base.Vector2d;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

public class GrassField implements IWorldMap {
    //Canmove to bez sprawdzenia, occupied nie
    private ArrayList<Grass> grassAreas = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    private MapVisualizer visualizer = new MapVisualizer(this);

    private Vector2d lowerLeft, upperRight;

    public GrassField(int numberOfGrassAreas){
        this.lowerLeft = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        this.upperRight = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        generateGrassGroups(numberOfGrassAreas);
    }

    private void generateGrassGroups(int numberOfGrassAreas) {
        Random generator = new Random();
        for(int i=0; i<numberOfGrassAreas; i++){
            Vector2d grassPosition;
            do{
                grassPosition = new Vector2d(
                        generator.nextInt((int)Math.sqrt(numberOfGrassAreas*10)),
                        generator.nextInt((int)Math.sqrt(numberOfGrassAreas*10)));
            }while (this.isOccupied(grassPosition));
            grassAreas.add(new Grass(grassPosition));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isAnimalThere(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight);
    }

    private boolean isAnimalThere(Vector2d position){
        for(Animal animal: this.animals)
            if (animal.getPosition().equals(position))
                return true;
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if(canMoveTo(animalPosition)){
            animals.add(animal);
            return true;
        }
        return false;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: this.animals)
            if (animal.getPosition().equals(position))
                return animal;
        for(Grass grass: this.grassAreas)
            if (grass.getPosition().equals(position))
                return grass;
        return null;
    }


    @Override
    public String toString(){
        for(Grass grass: grassAreas){
            System.out.println(grass.getPosition());
        }
        return visualizer.draw(this.getLowerOccupied(), this.getUpperOccupied());

    }

    private Vector2d getLowerOccupied(){
        Vector2d lower = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Animal animal : this.animals)
            lower = animal.getPosition().lowerLeft(lower);
        for(Grass grass : this.grassAreas)
            lower = grass.getPosition().lowerLeft(lower);
        return lower;

    }
    private Vector2d getUpperOccupied(){
        Vector2d upper = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Animal animal : this.animals)
            upper = animal.getPosition().upperRight(upper);
        for(Grass grass : this.grassAreas)
            upper = grass.getPosition().upperRight(upper);
        return upper;

    }
}
