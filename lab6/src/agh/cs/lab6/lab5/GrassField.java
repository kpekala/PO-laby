package agh.cs.lab6.lab5;

import agh.cs.lab6.extended_to_lab7.MapBoundary;
import agh.cs.lab6.lab5.prev.base.Animal;
import agh.cs.lab6.lab5.prev.base.Vector2d;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GrassField extends AbstractWorldMap {
    private final LinkedHashMap<Vector2d,Grass> grasses = new LinkedHashMap();

    public GrassField(int numberOfGrassAreas){
        this.lowerLeft = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        this.upperRight = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        generateGrassGroups(numberOfGrassAreas);
    }

    private void generateGrassGroups(int numberOfGrassAreas) {
        Random generator = new Random();
        for(int i=0; i<numberOfGrassAreas; i++){
            Vector2d grassPosition;
            do{
                grassPosition = new Vector2d(
                        generator.nextInt((int)Math.sqrt(numberOfGrassAreas*10)),
                        generator.nextInt((int)Math.sqrt(numberOfGrassAreas*10)));
            }while (this.isOccupied(grassPosition));
            Grass newGrass = new Grass(grassPosition);
            this.grasses.put(grassPosition,newGrass);
            mapBoundary.addElement(newGrass);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isAnimalThere(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight);
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object animal = animals.get(position);
        if(animal == null)
            return grasses.get(position);
        return animal;
    }


    @Override
    protected Vector2d getLowerOccupied(){
        Vector2d lower = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(IMapElement element : this.animals.values())
            lower = element.getPosition().lowerLeft(lower);
        for(IMapElement element : this.grasses.values())
            lower = element.getPosition().lowerLeft(lower);
        return lower;

    }
    @Override
    protected Vector2d getUpperOccupied(){
        Vector2d upper = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(IMapElement element : this.animals.values())
            upper = element.getPosition().upperRight(upper);
        for(IMapElement element : this.grasses.values())
            upper = element.getPosition().upperRight(upper);
        return upper;
    }

    public List<Grass> getGrassAreas() {
        return (List<Grass>) grasses.values();
    }
}
