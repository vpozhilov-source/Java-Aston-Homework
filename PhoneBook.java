import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;    
    
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }
    
    public void add(String surname, String phoneNumber) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new ArrayList<>());
        }
        phoneBook.get(surname).add(phoneNumber);
    }
    
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }
    
    public void printAll() {
        System.out.println("\nAll phonebook:");
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
