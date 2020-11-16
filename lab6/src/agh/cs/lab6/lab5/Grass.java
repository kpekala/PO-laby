package agh.cs.lab6.lab5;


import agh.cs.lab6.lab5.prev.base.Vector2d;

public class Grass implements IMapElement{
    private Vector2d position;
    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString(){
        return "*";
    }
}
