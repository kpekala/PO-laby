package agh.cs.lab6.lab5.prev;


import agh.cs.lab6.lab5.AbstractWorldMap;
import agh.cs.lab6.lab5.prev.base.Animal;
import agh.cs.lab6.lab5.prev.base.Vector2d;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap {

    private int width, height;
    private MapVisualizer visualizer = new MapVisualizer(this);

    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public RectangularMap(int width, int height){
        this.height = height;
        this.width = width;
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(this.width,this.height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight);
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
        return null;
    }

    @Override
    public String toString(){
        return visualizer.draw(this.lowerLeft, this.upperRight);
    }

    @Override
    protected Vector2d getLowerOccupied() {
        Vector2d lower = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(Animal animal : this.animals)
            lower = animal.getPosition().lowerLeft(lower);
        return lower;
    }

    @Override
    protected Vector2d getUpperOccupied() {
        Vector2d upper = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(Animal animal : this.animals)
            upper = animal.getPosition().upperRight(upper);
        return upper;
    }

    public ArrayList<Animal> getAnimals(){
        return this.animals;
    }
}
