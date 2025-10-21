import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    @Test
    void testAreaWithValidInput() {
        assertEquals(10.0, TriangleArea.calculateArea(5, 4), 0.001);
        assertEquals(25.5, TriangleArea.calculateArea(8.5, 6), 0.001);
    }

    @Test
    void testAreaWithZeroInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateArea(0, 5);
        });
    }

    @Test
    void testAreaWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateArea(-5, 10);
        });
    }
}