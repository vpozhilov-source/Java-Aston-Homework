public class Main {
  public static void main(String[] args) {
 Product[] productsArray = new Product[5];
    productsArray[0] = new Product("Samsung S25 Utra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
    productsArray[1] = new Product("Iphone 16", "15.01.2025", "Apple Inc.", "USA", 4499, false);
    productsArray[2] = new Product("Xiaomi Mi 14", "10.12.2024", "Xiaomi", "China", 2299, true);
    productsArray[3] = new Product("MacBook Pro", "01.03.2025", "Apple Inc", "USA", 2599, false);
    productsArray[4] = new Product("Galaxy Watch", "20.01.2025", "Samsung Corp", "Korea", 899, true);
  }
}
class Product {
  private String name;
  private String date;
  private String manufacturer;
  private String country;
  private double price;
  private boolean isReserved;
public Product(String name, String date, String manufacturer, String country, double price, boolean isReserved) {
  this.name = name;
  this.date = date;
  this.manufacturer = manufacturer;
  this.country = country;
  this.price = price;
  this.isReserved = isReserved;
}
public void printInfo() {
  System.out.println("Product: " + name);
  System.out.println("Date: " + date);
  System.out.println("Manufacturer: " + manufacturer);
  System.out.println("Country: " + country);
  System.out.println("Price: $" + price);
  System.out.println("Reserveed: " + isReserved);
}
}
class Park {
  class Attraction {
    private String name;
    private String workTime;
    private double price;
     public Attraction(String name, String workTime, double price) {
            this.name = name;
            this.workTime = workTime;
            this.price = price;
        }
        
        public void displayInfo() {
            System.out.println("Attraction: " + name);
            System.out.println("Work time: " + workTime);
            System.out.println("Price: $" + price);
        }
    }
}
    
  
                          
