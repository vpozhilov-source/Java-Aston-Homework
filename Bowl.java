public class Bowl {
    private int foodAmount;
    
    public Bowl(int initialFood) {
        this.foodAmount = initialFood;
    }
    
    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }
    
    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("Добавили " + amount + " еды. Теперь в миске: " + foodAmount);
    }
    
    public int getFoodAmount() {
        return foodAmount;
    }
}
