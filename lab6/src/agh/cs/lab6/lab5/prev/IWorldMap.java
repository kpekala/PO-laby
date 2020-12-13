package agh.cs.lab6.lab5.prev;

import agh.cs.lab6.lab5.IMapElement;
import agh.cs.lab6.lab5.prev.base.Animal;
import agh.cs.lab6.lab5.prev.base.Vector2d;

import java.util.LinkedHashMap;
import java.util.List;

public interface IWorldMap {

    boolean canMoveTo(Vector2d position);

    void place(Animal animal);

    boolean isOccupied(Vector2d position);

    Object objectAt(Vector2d position);

    public LinkedHashMap<Vector2d, Animal> getAnimals();
}