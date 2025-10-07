public class Park {
    private String parkName;
    
    public Park(String parkName) {
        this.parkName = parkName;
    }
    
    public class Attraction {
        private String name;
        private String workTime;
        private double price;
        
        public Attraction(String name, String workTime, double price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }
        
        public void printInfo() {
            System.out.println("Парк: " + parkName);
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workTime);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("------------------------");
        }
    }
}
