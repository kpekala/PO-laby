package agh.cs.lab6.lab5.prev;


import agh.cs.lab6.lab5.prev.base.Animal;
import agh.cs.lab6.lab5.prev.base.MoveDirection;
import agh.cs.lab6.lab5.prev.base.Vector2d;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {

    private IWorldMap map;
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final MoveDirection[] moves;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.map = map;
        for(Vector2d pos: positions) {
            Animal animal = new Animal(this.map, pos);
            this.map.place(animal);
            this.animals.add(animal);
        }
        this.moves = moves;
    }

    @Override
    public void run() {
        if(this.animals.isEmpty())
            return;
        int i = 0;
        for(MoveDirection direction: this.moves){
            Animal animalToMove = this.animals.get(i);
            animalToMove.move(direction);
            i = (i + 1) % this.animals.size();
        }
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
