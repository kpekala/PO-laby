package logic.map;

import logic.model.map.Grass;
import logic.model.map.animal.Animal;
import logic.model.Vector2d;

public interface IWorldMap {

    //boolean canMoveTo(Vector2d position);

    void place(Animal animal);
    void placeGrass(Grass grass);

    boolean isOccupied(Vector2d position);

    Object objectAt(Vector2d position);

    void eating();
    void breeding();
}