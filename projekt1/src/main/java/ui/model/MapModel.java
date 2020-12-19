package ui.model;

import logic.model.Vector2d;

import java.util.ArrayList;

public class MapModel {
    private ArrayList<AnimalModel> animalModels;
    private Vector2d[] grassModels;

    public MapModel(ArrayList<AnimalModel> animalModels, Vector2d[] grassModels) {
        this.animalModels = animalModels;
        this.grassModels = grassModels;
    }

    public ArrayList<AnimalModel> getAnimalModels() {
        return animalModels;
    }

    public void setAnimalModels(ArrayList<AnimalModel> animalModels) {
        this.animalModels = animalModels;
    }

    public Vector2d[] getGrassModels() {
        return grassModels;
    }

    public void setGrassModels(Vector2d[] grassModels) {
        this.grassModels = grassModels;
    }
}
