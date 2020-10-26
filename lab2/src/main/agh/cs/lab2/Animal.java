package agh.cs.lab2;

public class Animal {

    private MapDirection mapDirection;
    private Vector2d position;


    public Animal(){
        this.mapDirection = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.mapDirection = this.mapDirection.next();
            case LEFT -> this.mapDirection = this.mapDirection.previous();
            default -> {
                Vector2d moveVector = this.mapDirection.toUnitVector();
                Vector2d newPosition = this.position.add(moveVector);
                if(newPosition.follows(new Vector2d(0,0)) && newPosition.precedes(new Vector2d(4,4))){
                    this.position = newPosition;
                }
            }
        }

    }

    @Override
    public String toString(){
        return "Position: " + position.toString() + ", orientation: " + mapDirection.toString();
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getMapDirection() {
        return mapDirection;
    }

}
