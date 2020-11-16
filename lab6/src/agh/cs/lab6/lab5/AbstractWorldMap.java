package agh.cs.lab6.lab5;


import agh.cs.lab6.lab5.prev.IWorldMap;
import agh.cs.lab6.lab5.prev.MapVisualizer;
import agh.cs.lab6.lab5.prev.base.Animal;
import agh.cs.lab6.lab5.prev.base.Vector2d;

import java.util.ArrayList;
import java.util.LinkedHashMap;

abstract public class AbstractWorldMap implements IWorldMap {
    protected LinkedHashMap<Vector2d,IMapElement> elements = new LinkedHashMap();
    private MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d lowerLeft, upperRight;

    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    abstract public Object objectAt(Vector2d position);

    protected boolean isAnimalThere(Vector2d position){
        IMapElement element = elements.get(position);
        return element instanceof Animal && element.getPosition().equals(position);
    }

    @Override
    public void place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if(canMoveTo(animalPosition))
            elements.put(animalPosition,animal);
        throw new IllegalArgumentException("Animal can not be placed on an occupied place. Position: " + animalPosition);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }


    @Override
    public String toString(){
        return visualizer.draw(this.getLowerOccupied(), this.getUpperOccupied());
    }

    protected abstract Vector2d getLowerOccupied();
    protected abstract Vector2d getUpperOccupied();

    @Override
    public LinkedHashMap<Vector2d, IMapElement> getElements(){
        return this.elements;
    }
}
