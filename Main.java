public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", 
                                      "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16", "15.01.2025", 
                                      "Apple Inc.", "USA", 4999, false);
        productsArray[2] = new Product("Xiaomi Mi 14", "10.12.2024", 
                                      "Xiaomi Corp.", "China", 2999, true);
        productsArray[3] = new Product("Google Pixel 8", "20.11.2024", 
                                      "Google LLC", "USA", 3999, false);
        productsArray[4] = new Product("OnePlus 12", "05.01.2025", 
                                      "OnePlus Ltd.", "China", 3499, true);
        
        System.out.println("ИНФОРМАЦИЯ О ТОВАРАХ");
        for (Product product : productsArray) {
            product.printInfo();
        }
        
        Park disneyland = new Park("Диснейленд");
        
        Park.Attraction rollerCoaster = disneyland.new Attraction("Американские горки", "10:00-20:00", 500);
        Park.Attraction ferrisWheel = disneyland.new Attraction("Колесо обозрения", "09:00-22:00", 300);
        Park.Attraction waterSlide = disneyland.new Attraction("Водная горка", "11:00-19:00", 400);
        
        System.out.println("ИНФОРМАЦИЯ ОБ АТТРАКЦИОНАХ");
        rollerCoaster.printInfo();
        ferrisWheel.printInfo();
        waterSlide.printInfo();
    }
}
    
  
                          
