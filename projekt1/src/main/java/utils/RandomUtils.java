package utils;

import logic.model.Vector2d;

import java.util.Random;

public class RandomUtils {

    private final Random generator;
    public RandomUtils(){
        this.generator = new Random();
    }
    public  int randomAngle(){
        return generator.nextInt(8);
    }
    public Vector2d randomPosition(Vector2d upperRight){
        return new Vector2d(generator.nextInt(upperRight.x), generator.nextInt(upperRight.y));
    }
}
