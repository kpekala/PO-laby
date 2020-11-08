package test;

import agh.cs.lab4.IEngine;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab4.SimulationEngine;
import agh.cs.lab4.prev.Animal;
import agh.cs.lab4.prev.MoveDirection;
import agh.cs.lab4.prev.OptionsParser;
import agh.cs.lab4.prev.Vector2d;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegrationTest {
    private MoveDirection[] directions;

    public void testBefore(String[] arr, MoveDirection[] moves){
        MoveDirection[] moveDirections = OptionsParser.parse(arr);

        Assert.assertArrayEquals(moves, moveDirections);

        directions = OptionsParser.parse(arr);
    }
    @Test
    public void basicTest() {
        // Podstawowy test ze wstępu
        String[] arr = {"b", "backward", "f", "forward", "r", "right", "l", "left", "a"};
        MoveDirection[] moves = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT};
        testBefore(arr, moves);

        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        ArrayList<Vector2d> pos = new ArrayList<Vector2d>(List.of(new Vector2d(2, 2), new Vector2d(3, 4)));
        ArrayList<Animal> animals = ((RectangularMap)map).getAnimals();

        Assert.assertTrue(Arrays.deepEquals(pos.toArray(),animals.stream().map(Animal::getPosition).toArray()));
    }

    @Test
    public void moveOutOfMapTest() {
        // Podstawowy test ze wstępu
        String[] arr = {"f","f","f","f","f","f","f","f","f"};
        MoveDirection[] moves = {MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD};
        testBefore(arr, moves);
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = {new Vector2d(2, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Animal animal = ((RectangularMap)map).getAnimals().get(0);
        Assert.assertEquals(new Vector2d(2,4), animal.getPosition());
    }

    @Test
    public void collideTest() {
        // Podstawowy test ze wstępu
        String[] arr = {"f"};
        MoveDirection[] moves = {MoveDirection.FORWARD};
        testBefore(arr, moves);
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Animal animal = ((RectangularMap)map).getAnimals().get(0);
        Assert.assertEquals(new Vector2d(2,2), animal.getPosition());
    }
}
