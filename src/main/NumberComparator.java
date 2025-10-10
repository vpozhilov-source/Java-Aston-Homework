public class NumberComparator {
    public static String compareNumbers(int a, int b) {
        if (a > b) {
            return a + " is greater than " + b;
        } else if (a < b) {
            return a + " is less than " + b;
        } else {
            return a + " is equal to " + b;
        }
    }
}
