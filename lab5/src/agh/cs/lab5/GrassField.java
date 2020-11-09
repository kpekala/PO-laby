package agh.cs.lab5;

import agh.cs.lab5.prev.base.Animal;
import agh.cs.lab5.prev.base.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GrassField extends AbstractWorldMap {
    //Canmove to bez sprawdzenia, occupied nie

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
            this.elements.add(new Grass(grassPosition));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isAnimalThere(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(IMapElement element: this.elements)
            if (element.getPosition().equals(position))
                return element;
        return null;
    }


    @Override
    protected Vector2d getLowerOccupied(){
        Vector2d lower = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(IMapElement element : this.elements)
            lower = element.getPosition().lowerLeft(lower);
        return lower;

    }
    @Override
    protected Vector2d getUpperOccupied(){
        Vector2d upper = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(IMapElement element : this.elements)
            upper = element.getPosition().upperRight(upper);

        return upper;
    }

    public List<Animal> getAnimals() {
        return elements.stream()
                .filter(elements -> elements instanceof Animal)
                .map(element -> (Animal) element)
                .collect(Collectors.toList());
    }

    public List<Grass> getGrassAreas() {
        return elements.stream()
                .filter(elements -> elements instanceof Grass)
                .map(element -> (Grass) element)
                .collect(Collectors.toList());
    }
}
