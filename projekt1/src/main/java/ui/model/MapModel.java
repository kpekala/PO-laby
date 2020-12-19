package ui.model;

import logic.model.Vector2d;

import java.util.ArrayList;

public class MapModel {
    private ArrayList<AnimalModel> animalModels;
    private Vector2d[] grassModels;

    public MapModel(ArrayList<AnimalModel> animalModels, Vector2d[] grassModels) {
        this.animalModels = animalModels;
        this.grassModels = grassModels;

        processAnimals();
    }

    private void processAnimals() {
        if(animalModels.isEmpty())
            return;
        float maxEnergy = animalModels.stream().map(AnimalModel::getEnergy).max(Float::compareTo).get();
        for(AnimalModel model: animalModels){
            float relativeEnergy = model.getEnergy() / maxEnergy;
            relativeEnergy = relativeEnergy < 0 ? 0: relativeEnergy;
            relativeEnergy = relativeEnergy > 1 ? 1: relativeEnergy;
            model.setRelativeEnergy(1 - relativeEnergy);
        }
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
