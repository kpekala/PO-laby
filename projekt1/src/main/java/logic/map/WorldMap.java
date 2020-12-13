package logic.map;

import logic.model.Animal;
import logic.model.Vector2d;

public class WorldMap implements IWorldMap {

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public void place(Animal animal) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
