package utils;

import logic.map.WorldMap;
import logic.model.Vector2d;

public class VectorUtils {
    public static Vector2d adjustedPosition(Vector2d pos, WorldMap map){
        Vector2d position = pos;
        if (position.x >= map.getWidth())
            position = new Vector2d(position.x - map.getWidth(), position.y);
        if (position.y >= map.getHeight())
            position = new Vector2d(position.x, position.y - map.getHeight());
        if (position.x < 0)
            position =  new Vector2d(map.getWidth() + position.x, position.y);
        if (position.y < 0)
            position = new Vector2d(position.x, map.getHeight() + position.y);
        return position;
    }
}
