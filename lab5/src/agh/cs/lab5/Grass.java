package agh.cs.lab5;

import agh.cs.lab5.prev.base.Vector2d;

public class Grass {
    private Vector2d position;
    public Grass(Vector2d position){
        this.position = position;
    }
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString(){
        return "*";
    }
}
