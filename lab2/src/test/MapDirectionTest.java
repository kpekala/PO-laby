import agh.cs.lab2.MapDirection;
import agh.cs.lab2.World;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapDirectionTest {

    @Test
    public void  nextTest(){
        MapDirection mapDirection = MapDirection.NORTH;
        assertEquals(mapDirection.next(),MapDirection.EAST);

        mapDirection = MapDirection.EAST;
        assertEquals(mapDirection.next(),MapDirection.SOUTH);

        mapDirection = MapDirection.SOUTH;
        assertEquals(mapDirection.next(),MapDirection.WEST);

        mapDirection = MapDirection.WEST;
        assertEquals(mapDirection.next(),MapDirection.NORTH);
    }

    @Test
    public void  previousTest(){
        MapDirection mapDirection = MapDirection.NORTH;
        assertEquals(mapDirection.previous(),MapDirection.WEST);

        mapDirection = MapDirection.EAST;
        assertEquals(mapDirection.previous(),MapDirection.NORTH);

        mapDirection = MapDirection.SOUTH;
        assertEquals(mapDirection.previous(),MapDirection.EAST);

        mapDirection = MapDirection.WEST;
        assertEquals(mapDirection.previous(),MapDirection.SOUTH);
    }
}
