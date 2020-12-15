package ui.model;

import logic.model.Vector2d;
import logic.model.map.animal.Animal;

public class AnimalModel {
    private Vector2d position;
    private int energy;

    public AnimalModel(Animal animal){
        position = new Vector2d(animal.getPosition().x, animal.getPosition().y);
        energy = animal.getEnergy();
    }

    public int getEnergy() {
        return energy;
    }

    public Vector2d getPosition() {
        return position;
    }
}
