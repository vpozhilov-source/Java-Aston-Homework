public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        phoneBook.add("Ivanov", "+7-900-123-45-67");
        phoneBook.add("Petrov", "+7-900-765-43-21");
        phoneBook.add("Ivanov", "+7-900-999-99-99"); 
        phoneBook.add("Sidorov", "+7-900-111-22-33");
        phoneBook.add("Petrov", "+7-900-888-77-66"); 
        
        phoneBook.printAll();
        
        System.out.println("\nSearch by surname:");
        
        List<String> ivanovPhones = phoneBook.get("Ivanov");
        System.out.println("Ivanov: " + ivanovPhones);
        
        List<String> petrovPhones = phoneBook.get("Petrov");
        System.out.println("Petrov: " + petrovPhones);
        
        List<String> smirnovPhones = phoneBook.get("Smirnov"); 
        System.out.println("Smirnov: " + smirnovPhones);
    }
}
