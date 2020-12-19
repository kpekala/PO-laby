package ui.model;

import logic.model.Vector2d;
import logic.model.map.animal.Animal;

public class AnimalModel {
    private Vector2d position;
    private float energy;
    private float relativeEnergy;

    public AnimalModel(Animal animal){
        position = new Vector2d(animal.getPosition().x, animal.getPosition().y);
        energy = animal.getEnergy();
        relativeEnergy = 0;
    }

    public float getEnergy() {
        return energy;
    }

    public Vector2d getPosition() {
        return position;
    }

    public float getRelativeEnergy() {
        return relativeEnergy;
    }

    public void setRelativeEnergy(float relativeEnergy) {
        this.relativeEnergy = relativeEnergy;
    }
}
