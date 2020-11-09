package agh.cs.lab5;

import agh.cs.lab5.prev.IEngine;
import agh.cs.lab5.prev.IWorldMap;
import agh.cs.lab5.prev.RectangularMap;
import agh.cs.lab5.prev.SimulationEngine;
import agh.cs.lab5.prev.base.MoveDirection;
import agh.cs.lab5.prev.base.OptionsParser;
import agh.cs.lab5.prev.base.Vector2d;

public class World {

    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
    }
}
