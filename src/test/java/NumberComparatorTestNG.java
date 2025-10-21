import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {

    @Test
    public void testGreaterThan() {
        assertEquals(NumberComparator.compareNumbers(10, 5), "10 is greater than 5");
    }

    @Test
    public void testLessThan() {
        assertEquals(NumberComparator.compareNumbers(5, 10), "5 is less than 10");
    }

    @Test
    public void testEqual() {
        assertEquals(NumberComparator.compareNumbers(10, 10), "10 is equal to 10");
    }
}