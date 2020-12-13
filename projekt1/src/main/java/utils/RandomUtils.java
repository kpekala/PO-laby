package utils;

import java.util.Random;

public class RandomUtils {

    private Random generator;
    public RandomUtils(){
        this.generator = new Random();
    }
    public  int randomAngle(){
        return generator.nextInt(8);
    }
}
