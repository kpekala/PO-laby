package logic.model;

import logic.model.map.animal.Animal;

import java.util.ArrayList;

public class Statistics {

    private final ArrayList<Animal> animals;

    public Statistics(ArrayList<Animal> animals){
        this.animals = animals;
    }

    public float getAverageEnergy(){
        if(animals.size() == 0)
            return 0f;
        float sum = 0;
        for(Animal a: animals){
            sum += a.getEnergy();
        }
        return sum / animals.size();
    }

    public float getAverageChildNumber(){
        if(animals.size() == 0)
            return 0f;
        float sum = 0;
        for(Animal a: animals){
            sum += a.getChildNumber();
        }
        return sum / animals.size();
    }
}
