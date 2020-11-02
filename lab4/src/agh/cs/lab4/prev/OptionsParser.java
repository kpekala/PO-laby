package agh.cs.lab4.prev;

import java.util.ArrayList;

public class OptionsParser {
    public static MoveDirection[] parse(String[] keys){
        ArrayList<MoveDirection> directions = new ArrayList<>();
        for(String key: keys){
            switch (key){
                case "f","forward" -> directions.add(MoveDirection.FORWARD);
                case "b","backward" -> directions.add(MoveDirection.BACKWARD);
                case "r","right" -> directions.add(MoveDirection.RIGHT);
                case "l","left" -> directions.add(MoveDirection.LEFT);
             }
        }
        MoveDirection[] result = new MoveDirection[directions.size()];
        result = directions.toArray(result);
        return result;
    }
}
