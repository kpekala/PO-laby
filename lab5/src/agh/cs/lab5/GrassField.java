package agh.cs.lab5;

import agh.cs.lab5.prev.base.Animal;
import agh.cs.lab5.prev.base.Vector2d;

import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    //Canmove to bez sprawdzenia, occupied nie
    private ArrayList<Grass> grassAreas = new ArrayList<>();

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
    protected Vector2d getLowerOccupied(){
        Vector2d lower = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Animal animal : this.animals)
            lower = animal.getPosition().lowerLeft(lower);
        for(Grass grass : this.grassAreas)
            lower = grass.getPosition().lowerLeft(lower);
        return lower;

    }
    @Override
    protected Vector2d getUpperOccupied(){
        Vector2d upper = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Animal animal : this.animals)
            upper = animal.getPosition().upperRight(upper);
        for(Grass grass : this.grassAreas)
            upper = grass.getPosition().upperRight(upper);
        return upper;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Grass> getGrassAreas() {
        return grassAreas;
    }
}
