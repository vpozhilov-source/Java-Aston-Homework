public interface GeometricShape {
    String getFillColor();
    String getBorderColor();
    
    default double calculatePerimeter() {
        return 0.0;
    }
    
    default double calculateArea() {
        return 0.0;
    }
    
    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter() + 
                         ", Площадь: " + calculateArea() + 
                         ", Цвет фона: " + getFillColor() + 
                         ", Цвет границ: " + getBorderColor());
    }
}
