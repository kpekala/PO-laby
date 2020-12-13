package logic.map;

import logic.model.Animal;
import logic.model.Vector2d;

import java.util.LinkedHashMap;

public interface IWorldMap {

    boolean canMoveTo(Vector2d position);


    void place(Animal animal);


    boolean isOccupied(Vector2d position);

    Object objectAt(Vector2d position);

}