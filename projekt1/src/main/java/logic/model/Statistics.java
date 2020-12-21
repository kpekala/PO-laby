package logic.model;

import logic.model.map.Grass;
import logic.model.map.animal.Animal;
import ui.model.StatisticsModel;

import java.util.ArrayList;

public class Statistics {

    private final ArrayList<Animal> animals;
    private final ArrayList<Grass> grasses;

    private int numberOfDeaths = 0;
    private float avgLifeSpan = 0;
    private int mostPopularGen = 0;

    public Statistics(ArrayList<Animal> animals, ArrayList<Grass> grasses){
        this.animals = animals;
        this.grasses = grasses;
    }

    public StatisticsModel generateStatisticsModel(){
        if(animals.size() == 0)
            return new StatisticsModel(0,grasses.size(),0,0,0,0);
        int animalsNumber = animals.size();
        int grassNumber = grasses.size();

        int sumACN = 0;
        float sumEnergy = 0;
        int[] genesCounts = new int[8];

        for(Animal animal: animals){
            sumACN += animal.getChildNumber();
            sumEnergy += animal.getEnergy();
            genesCounts[animal.getMostPopularGen()]++;
        }
        int maxI = 0;
        int maxV = 0;
        for(int i=0; i<8; i++){
            if(genesCounts[i] > maxV){
                maxV = genesCounts[i];
                maxI = i;
            }
        }
        mostPopularGen = maxI;
        return new StatisticsModel(animalsNumber, grassNumber,
                mostPopularGen,
                sumEnergy / animals.size(),
                avgLifeSpan,
                sumACN / (float)animals.size()
                );
    }

    public void addDeadAnimal(Animal animal){
        numberOfDeaths++;
        if(numberOfDeaths == 1){
            avgLifeSpan = animal.getLifeSpan();
            return;
        }
        float oldLifeSpanSum = avgLifeSpan * (numberOfDeaths-1);
        avgLifeSpan = (oldLifeSpanSum + animal.getLifeSpan()) / numberOfDeaths;
    }

    public int getMostPopularGen() {
        return mostPopularGen;
    }
}
