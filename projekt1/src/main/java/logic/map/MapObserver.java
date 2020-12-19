package logic.map;

import logic.model.map.Grass;
import logic.model.map.animal.Animal;

public interface MapObserver {
    public void onGrassRemoved(Grass grass);
    void onAnimalBorn(Animal animal);
}
