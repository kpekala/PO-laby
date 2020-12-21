package logic.model.map.animal;


import logic.map.WorldMap;
import logic.model.Vector2d;
import utils.RandomUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Animal implements IMapElement {

    public static int GENES_NUMBER = 32;

    private MapDirection mapDirection;
    private Vector2d position;
    private final WorldMap map;
    private float energy;
    private int lifeSpan = 0;
    private int deathDay = -1;
    private int childNumber = 0;
    private int mostPopularGen = 0;

    private int[] genes;

    public Animal(WorldMap map, Vector2d initialPosition, float energyAtStart){
        this.map = map;
        this.mapDirection = new MapDirection(0);
        this.position = initialPosition;
        this.energy = energyAtStart;
        this.genes = new int[GENES_NUMBER];
        generateGenes();
    }

    private void generateGenes() {
        RandomUtils randomUtils = new RandomUtils();
        for(int i = 0; i<GENES_NUMBER; i++){
            genes[i] = randomUtils.randomAngle();
        }
        correctGenes();
        findMostPopularGen();
    }


    public void makeBirthGenes(Animal parent1, Animal parent2){
        int[] genesCounts = new int[3];
        genesCounts[0] = RandomUtils.intRange(1,30);
        genesCounts[1] = RandomUtils.intRange(1, 32 - (genesCounts[0] + 1));
        genesCounts[2] = 32 - (genesCounts[0] + genesCounts[1]);
        if(genesCounts[0] + genesCounts[1] + genesCounts[2] != 32){
            System.out.println("Ups");
        }

        int iter = 0;
        for(int i=0; i<3; i++){
            Animal p = i==0 ? parent1 : parent2;
            for(int j=0; j<genesCounts[i]; j++){
                genes[iter + j] = p.genes[iter + j];
            }
            iter += genesCounts[i];
        }
        correctGenes();
        findMostPopularGen();
    }

    private void findMostPopularGen() {
        int[] genesCounts = new int[8];
        for(int gen: genes){
            genesCounts[gen]++;
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
    }


    private void correctGenes() {
        int k=0;
        for(int i = 0; i<MapDirection.ANGLES_NUMBER; i++){
            int finalI = i;
            if(IntStream.of(genes).noneMatch(x -> x == finalI)){
                genes[k] = i;
                k++;
            }
        }
        Arrays.sort(genes);
    }

    public boolean isDead(){
        return deathDay != -1;
    }


    public void move(){
        lifeSpan++;
        Vector2d oldPosition = position;
        position = position.add(mapDirection.getCoordinates());
        adjustPosition();

        map.onAnimalMoved(this, oldPosition, position);
    }

    private void adjustPosition() {
        if (position.x >= map.getWidth())
            position = new Vector2d(position.x - map.getWidth(), position.y);
        if (position.y >= map.getHeight())
            position = new Vector2d(position.x, position.y - map.getHeight());
        if (position.x < 0)
            position =  new Vector2d(map.getWidth() + position.x, position.y);
        if (position.y < 0)
            position = new Vector2d(position.x, map.getHeight() + position.y);
    }

    public void changeDirection(){
        int newAngle = genes[new Random().nextInt(32)];
        mapDirection.update(newAngle);
    }

    public void updateEnergy(double energyDelta){
        this.energy += energyDelta;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getMapDirection() {
        return mapDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return mapDirection == animal.mapDirection &&
                position.equals(animal.position) &&
                map.equals(animal.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapDirection, position, map);
    }

    public int[] getGenes() {
        return genes;
    }

    public float getEnergy() {
        return energy;
    }

    public void updateOnBreed(float breedEnergy) {
        this.energy -= breedEnergy;
        this.childNumber++;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public int getChildNumber() {
        return childNumber;
    }

    public int getMostPopularGen() {
        return mostPopularGen;
    }

    public int getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(int deathDay) {
        this.deathDay = deathDay;
    }
}
