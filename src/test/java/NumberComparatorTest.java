import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @Test
    void testGreaterThan() {
        assertEquals("10 is greater than 5", NumberComparator.compareNumbers(10, 5));
    }

    @Test
    void testLessThan() {
        assertEquals("5 is less than 10", NumberComparator.compareNumbers(5, 10));
    }

    @Test
    void testEqual() {
        assertEquals("10 is equal to 10", NumberComparator.compareNumbers(10, 10));
    }
}