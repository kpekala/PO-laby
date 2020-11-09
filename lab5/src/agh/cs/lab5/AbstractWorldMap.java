package agh.cs.lab5;

import agh.cs.lab5.prev.IWorldMap;
import agh.cs.lab5.prev.MapVisualizer;
import agh.cs.lab5.prev.base.Animal;
import agh.cs.lab5.prev.base.Vector2d;

import java.util.ArrayList;

abstract public class AbstractWorldMap implements IWorldMap {
    protected ArrayList<IMapElement> elements = new ArrayList<>();
    private MapVisualizer visualizer = new MapVisualizer(this);
    protected Vector2d lowerLeft, upperRight;

    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    abstract public Object objectAt(Vector2d position);

    protected boolean isAnimalThere(Vector2d position){
        for(IMapElement element: this.elements)
            if (element instanceof Animal && element.getPosition().equals(position))
                return true;
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if(canMoveTo(animalPosition)){
            elements.add(animal);
            return true;
        }
        return false;
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
}
