import logic.model.animal.Animal;
import logic.model.Vector2d;
import org.junit.Test;

import java.util.Arrays;


public class AnimalTest {

    @Test
    public void genesTest(){
        for(int i=0; i<10; i++){
            Animal animal = new Animal(null, new Vector2d(2,2), 10);
            System.out.println(Arrays.toString(animal.getGenes()));
        }
    }
}
