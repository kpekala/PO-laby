package agh.cs.lab4;

import agh.cs.lab4.prev.Animal;
import agh.cs.lab4.prev.MoveDirection;
import agh.cs.lab4.prev.Vector2d;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {

    private int width, height;
    private MapVisualizer visualizer = new MapVisualizer(this);
    private Vector2d lowerLeft, upperRight;

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
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if(canMoveTo(animalPosition)){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if(this.animals.isEmpty())
            return;
        int i = 0;
        for(MoveDirection direction: directions){
            this.animals.get(i).move(direction);
            i = (i + 1) % this.animals.size();
        }
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
}
