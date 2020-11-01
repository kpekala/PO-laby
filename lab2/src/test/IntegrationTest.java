import agh.cs.lab2.*;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {
    @Test
    public void test(){
        String[] arr = {"b","backward","f", "forward","r","right","l","left", "a"};
        MoveDirection[] moveDirections = OptionsParser.parse(arr);
        MoveDirection[] moves = {MoveDirection.BACKWARD,MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
        MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT};
        Assert.assertArrayEquals(moves, moveDirections);

        Animal animal = new Animal();
        Vector2d lastPosition = animal.getPosition();
        MapDirection lastOrientation = animal.getMapDirection();
        for(MoveDirection move: moves){
            animal.move(move);
        }
        // Czy wykonuje poprawne ruchy i posiada poprawny kierunek
        Assert.assertEquals(new Vector2d(2,2), animal.getPosition());
        Assert.assertEquals(MapDirection.NORTH, animal.getMapDirection());

        // Czy nie wychodzi za plansze
        MoveDirection[] moves2 = {MoveDirection.BACKWARD,MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        for(MoveDirection move: moves2) {
            animal.move(move);
        }
        Assert.assertEquals(new Vector2d(2,0),animal.getPosition());
    }
}
