import agh.cs.lab2.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        assertEquals(new Vector2d(2, 1), new Vector2d(2, 1));
        assertNotEquals(new Vector2d(2, 1), new Vector2d(2, 2));
    }

    @Test
    public void toStringTest(){
        assertEquals(new Vector2d(2, 1).toString(), "(2,1)");
    }

    @Test
    public void precedesTest(){
        assertTrue(new Vector2d(2, 1).precedes(new Vector2d(2,2)));
        assertFalse(new Vector2d(2, 2).precedes(new Vector2d(2,1)));
    }

    @Test
    public void follows(){
        assertFalse(new Vector2d(2, 1).follows(new Vector2d(2,2)));
        assertTrue(new Vector2d(2, 2).follows(new Vector2d(2,1)));
    }
    @Test
    public void assertUpperRight(){
        assertEquals(new Vector2d(2,1).upperRight(new Vector2d(2,2)),new Vector2d(2,2));
        assertEquals(new Vector2d(1,2).upperRight(new Vector2d(4,1)),new Vector2d(4,2));
    }
    @Test
    public void assertLowerLeft(){
        assertEquals(new Vector2d(2,1).lowerLeft(new Vector2d(2,2)),new Vector2d(2,1));
        assertEquals(new Vector2d(1,2).lowerLeft(new Vector2d(4,1)),new Vector2d(1,1));
    }

    @Test
    public void assertAdd(){
        assertEquals(new Vector2d(2,1).add(new Vector2d(2,2)),new Vector2d(4,3));
        assertEquals(new Vector2d(1,2).add(new Vector2d(4,1)),new Vector2d(5,3));
    }

    @Test
    public void assertSubtract(){
        assertEquals(new Vector2d(2,1).subtract(new Vector2d(2,2)),new Vector2d(0,-1));
        assertEquals(new Vector2d(1,2).subtract(new Vector2d(4,1)),new Vector2d(-3, 1));
    }
    @Test
    public void assertOpposite(){
        assertEquals(new Vector2d(2,1).opposite(),new Vector2d(-2, -1));
        assertEquals(new Vector2d(2,-1).opposite(),new Vector2d(-2, 1));
    }
}
