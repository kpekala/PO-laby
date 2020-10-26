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
        Assert.assertArrayEquals(moveDirections,moves);

        Animal animal = new Animal();
        Vector2d lastPosition = animal.getPosition();
        MapDirection lastOrientation = animal.getMapDirection();
        for(MoveDirection move: moves){
            animal.move(move);
        }
    }
}
