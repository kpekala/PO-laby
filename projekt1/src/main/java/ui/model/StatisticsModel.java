package ui.model;

public class StatisticsModel {

    private final int animalsNumber;
    private final int grassNumber;
    private final int mostPopularGen;
    private final float avgEnergy;
    private final float avgLifeSpan;
    private final float avgChildNumber;

    public StatisticsModel(int animalsNumber, int grassNumber, int mostPopularGen, float avgEnergy, float avgLifeSpan, float avgChildNumber) {
        this.animalsNumber = animalsNumber;
        this.grassNumber = grassNumber;
        this.mostPopularGen = mostPopularGen;
        this.avgEnergy = avgEnergy;
        this.avgLifeSpan = avgLifeSpan;
        this.avgChildNumber = avgChildNumber;
    }

    public int getAnimalsNumber() {
        return animalsNumber;
    }

    public int getGrassNumber() {
        return grassNumber;
    }

    public int getMostPopularGen() {
        return mostPopularGen;
    }

    public float getAvgEnergy() {
        return avgEnergy;
    }

    public float getAvgLifeSpan() {
        return avgLifeSpan;
    }

    public float getAvgChildNumber() {
        return avgChildNumber;
    }
}
