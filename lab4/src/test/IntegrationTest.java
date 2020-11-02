package test;

import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab4.prev.Animal;
import agh.cs.lab4.prev.MoveDirection;
import agh.cs.lab4.prev.OptionsParser;
import agh.cs.lab4.prev.Vector2d;
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

        IWorldMap map = new RectangularMap(10, 5);


        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4))); }
}
