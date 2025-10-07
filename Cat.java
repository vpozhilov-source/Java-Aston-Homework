public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;
    private static final int MAX_RUN_DISTANCE = 200;
    
    public Cat(String name) {
        super(name);
        catCount++;
    }
    
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
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
