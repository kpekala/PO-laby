package agh.cs.lab4;

import agh.cs.lab4.prev.Animal;
import agh.cs.lab4.prev.MoveDirection;
import agh.cs.lab4.prev.OptionsParser;
import agh.cs.lab4.prev.Vector2d;

public class World {

    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
    }
}
