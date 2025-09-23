public class HomeWorkApp {
    
    // Метод 1: Печатает три слова в столбец
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    
    // Метод 2: Проверяет сумму двух чисел
    public static void checkSumSign() {
        int a = 5;
        int b = -3;
        int sum = a + b;
        
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    
    public static void main(String[] args) {
        // Проверяем метод 1
        System.out.println("=== Метод 1 ===");
        printThreeWords();
        
        // Проверяем метод 2
        System.out.println("=== Метод 2 ===");
        checkSumSign();
    }
}
