//ЗАДАНИЕ 1

class Animal {
    protected String name;
    protected static int animalCount = 0;
    
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }
    
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }
    
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
    
    public static int getAnimalCount() {
        return animalCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0;
    
    public Cat(String name) {
        super(name);
        catCount++;
    }
    
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
        }
    }
    
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }
    
    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            isFull = true;
            System.out.println(name + " покушал и теперь сыт!");
        } else {
            System.out.println(name + " не смог покушать. В миске мало еды!");
        }
    }
    
    public boolean isFull() {
        return isFull;
    }
    
    public static int getCatCount() {
        return catCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    
    public Dog(String name) {
        super(name);
        dogCount++;
    }
    
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимум: " + MAX_RUN_DISTANCE + " м.");
        }
    }
    
    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. Максимум: " + MAX_SWIM_DISTANCE + " м.");
        }
    }
    
    public static int getDogCount() {
        return dogCount;
    }
}

class Bowl {
    private int foodAmount;
    
    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }
    
    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            System.out.println("Еды в миске осталось: " + foodAmount);
            return true;
        } else {
            System.out.println("Недостаточно еды! В миске: " + foodAmount + ", а нужно: " + amount);
            return false;
        }
    }
    
    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("Добавили " + amount + " еды. Теперь в миске: " + foodAmount);
    }
    
    public int getFoodAmount() {
        return foodAmount;
    }
}

// ЗАДАНИЕ 2

interface GeometricShape {
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

class Circle implements GeometricShape {
    private double radius;
    private String fillColor;
    private String borderColor;
    
    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public String getFillColor() {
        return fillColor;
    }
    
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements GeometricShape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;
    
    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public String getFillColor() {
        return fillColor;
    }
    
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements GeometricShape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;
    
    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
    
    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
    
    @Override
    public String getFillColor() {
        return fillColor;
    }
    
    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
