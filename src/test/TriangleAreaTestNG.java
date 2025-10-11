import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTestNG {

    @Test
    public void testAreaWithValidInput() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithZeroInput() {
        TriangleArea.calculateArea(0, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithNegativeInput() {
        TriangleArea.calculateArea(-5, 10);
    }
}