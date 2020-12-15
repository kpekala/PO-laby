package ui.model;

import java.util.ArrayList;

public class MapModel {
    private ArrayList<AnimalModel> animalModels;

    public MapModel(ArrayList<AnimalModel> animalModels) {
        this.animalModels = animalModels;
    }

    public ArrayList<AnimalModel> getAnimalModels() {
        return animalModels;
    }

    public void setAnimalModels(ArrayList<AnimalModel> animalModels) {
        this.animalModels = animalModels;
    }
}
