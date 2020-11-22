package test;

import agh.cs.lab6.lab5.GrassField;
import agh.cs.lab6.lab5.prev.IEngine;
import agh.cs.lab6.lab5.prev.SimulationEngine;
import agh.cs.lab6.lab5.prev.base.Animal;
import agh.cs.lab6.lab5.prev.base.MoveDirection;
import agh.cs.lab6.lab5.prev.base.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class GrassFieldTest {
    @Test
    public void testObjectAt(){
        MoveDirection[] directions = {MoveDirection.FORWARD, MoveDirection.FORWARD};
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        //Testowanie polozenia przed ruchem
        Assert.assertEquals(new Animal(map, new Vector2d(2,2)),map.objectAt(new Vector2d(2,2)));
        Assert.assertEquals(new Animal(map, new Vector2d(3,4)),map.objectAt(new Vector2d(3,4)));
        engine.run();
        Assert.assertEquals(new Animal(map, new Vector2d(2,3)),map.objectAt(new Vector2d(2,3)));
        Assert.assertEquals(new Animal(map, new Vector2d(3,5)),map.objectAt(new Vector2d(3,5)));
    }

    @Test
    public void testCanMoveTo(){
        MoveDirection[] directions = {MoveDirection.FORWARD, MoveDirection.FORWARD};
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        Animal a1 = engine.getAnimals().get(0);
        Assert.assertTrue(map.canMoveTo(new Vector2d(2,3)));
        a1.move(MoveDirection.FORWARD);
        Assert.assertFalse(map.canMoveTo(new Vector2d(2,3)));
        engine.run();

    }

    @Test
    public void testPlace(){
        MoveDirection[] directions = {};
        GrassField map = new GrassField(10);
        Vector2d pos = new Vector2d(2,2);
        map.place(new Animal(map, pos));
        Assert.assertTrue(map.isOccupied(pos));
    }
}
