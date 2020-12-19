package utils;

import logic.model.Vector2d;

import java.util.Random;

public class RandomUtils {

    public final Random generator;
    public RandomUtils(){
        this.generator = new Random();
    }
    public  int randomAngle(){
        return generator.nextInt(8);
    }
    public Vector2d randomPosition(Vector2d upperRight){
        return new Vector2d(generator.nextInt(upperRight.x), generator.nextInt(upperRight.y));
    }

    public Vector2d randomPositionOnRect(Vector2d lowerLeft, Vector2d upperRight){
        return new Vector2d(generator.nextInt(upperRight.x - lowerLeft.x) + lowerLeft.x,
                generator.nextInt(upperRight.y - lowerLeft.y) + lowerLeft.y);
    }

    public static int intRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
