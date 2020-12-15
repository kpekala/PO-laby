package logic.model.map.animal;


import logic.map.WorldMap;
import logic.model.Vector2d;
import utils.RandomUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Animal implements IMapElement {

    public static int GENES_NUMBER = 32;

    private MapDirection mapDirection;
    private Vector2d position;
    private final WorldMap map;
    private int energy;


    private int[] genes;

    public Animal(WorldMap map, Vector2d initialPosition, int energyAtStart){
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


    public void move(){

    }

    public void changeDirection(){

    }

    public void updateEnergy(int energyDelta){
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
