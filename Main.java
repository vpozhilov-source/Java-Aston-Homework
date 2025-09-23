public class Main {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    
    public static void checkSumSign() {
        int a = 10;
        int b = -5;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    
    public static void printColor() {
        int value = 75;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    
    public static void compareNumbers() {
        int a = 7;
        int b = 12;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
    
    public static boolean isNegative(int number) {
        return number < 0;
    }
    
    public static void printStringMultipleTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }
    
    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }
    
    public static void multiplyIfLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }
    
    public static void fillDiagonals() {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
    }
    
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Метод 1 ===");
        printThreeWords();
        
        System.out.println("=== Метод 2 ===");
        checkSumSign();
        
        System.out.println("=== Метод 3 ===");
        printColor();
        
        System.out.println("=== Метод 4 ===");
        compareNumbers();
        
        System.out.println("=== Метод 5 ===");
        System.out.println(isSumInRange(5, 7));
        
        System.out.println("=== Метод 6 ===");
        checkNumber(-5);
        
        System.out.println("=== Метод 7 ===");
        System.out.println(isNegative(10));
        
        System.out.println("=== Метод 8 ===");
        printStringMultipleTimes("Hello", 3);
        
        System.out.println("=== Метод 9 ===");
        System.out.println(isLeapYear(2024));
        
        System.out.println("=== Метод 10 ===");
        invertArray();
        
        System.out.println("=== Метод 11 ===");
        fillArray();
        
        System.out.println("=== Метод 12 ===");
        multiplyIfLessThanSix();
        
        System.out.println("=== Метод 13 ===");
        fillDiagonals();
        
        System.out.println("=== Метод 14 ===");
        int[] result = createArray(5, 10);
        System.out.println("Массив создан");
    }
}
