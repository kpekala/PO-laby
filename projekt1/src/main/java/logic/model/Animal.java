package logic.model;


import logic.map.WorldMap;
import logic.model.animal.MoveDirection;

import java.util.ArrayList;
import java.util.Objects;

public class Animal implements IMapElement {

    private MapDirection mapDirection;
    private Vector2d position;
    private WorldMap map;

    public Animal(){
        //Teraz niebezpiecznie jest go używać, co z obiektem map?
        this.mapDirection = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(WorldMap map){
        this.map = map;
        this.mapDirection = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(WorldMap map, Vector2d initialPosition){
        this.map = map;
        this.mapDirection = MapDirection.NORTH;
        this.position = initialPosition;
    }
    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.mapDirection = this.mapDirection.next();
            case LEFT -> this.mapDirection = this.mapDirection.previous();
            default -> {
                Vector2d moveVector = this.mapDirection.toUnitVector();
                Vector2d newPosition;
                if(direction == MoveDirection.FORWARD)
                    newPosition = this.position.add(moveVector);
                else
                    newPosition = this.position.subtract(moveVector);
                if(map.canMoveTo(newPosition)){
                    Vector2d oldPosition = this.position;
                    this.position = newPosition;
                    //positionChanged(oldPosition, newPosition);
                }
            }
        }

    }

    @Override
    public String toString(){
        return mapDirection.code();
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
}
