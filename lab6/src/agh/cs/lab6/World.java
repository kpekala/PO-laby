package agh.cs.lab6;

import agh.cs.lab6.lab5.GrassField;
import agh.cs.lab6.lab5.prev.IEngine;
import agh.cs.lab6.lab5.prev.IWorldMap;
import agh.cs.lab6.lab5.prev.SimulationEngine;
import agh.cs.lab6.lab5.prev.base.MoveDirection;
import agh.cs.lab6.lab5.prev.base.OptionsParser;
import agh.cs.lab6.lab5.prev.base.Vector2d;

public class World {

    public static void main(String[] args) {
        try {
            checkArguments(args);
            MoveDirection[] directions = OptionsParser.parse(args);
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }catch (IllegalArgumentException ex){
            System.out.println(ex.toString());
            System.exit(1);
        }

    }

    private static void checkArguments(String[] args){
        for (String arg: args){
            if (!OptionsParser.isCorrect(arg))
                throw new IllegalArgumentException(arg + " is not legal move specification");
        }
    }
}
