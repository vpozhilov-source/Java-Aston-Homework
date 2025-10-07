// Задание 1.
import java.util.*;
class Student {
    private String name;
    private String group; 
    private int course;
    private List<Integer> grades;
  public Student(String name, String group, int course, List<Integer> grades) {
    this.name = name;
    this.group = group;
    this.course = course;
    this.grades = grades;
}
public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
    this.course = course;
}
    public double calculateAverage() {
    if (grades == null || grades.isEmpty()) return 0;
    int sum = 0;
    for (int grade : grades) {
        sum += grade;
    }
    return (double) sum / grades.size();
}
   public String getName() {
        return name;
    }
}
public class Main {
    public static void main(String[] args) {
Student student1 = new Student("Ben", "211", 1, Arrays.asList(4,5,3,4));
Student student2 = new Student("Tom", "200", 3, Arrays.asList(3,5,4,3));
Student student3 = new Student("Harry", "205", 2, Arrays.asList(4,4,4,3));
Student student4 = new Student("Jack", "100", 1, Arrays.asList(2,2,2,2));        
      List<Student> journal = new ArrayList <>();
      journal.add(student1);
      journal.add(student2);
      journal.add(student3);
      journal.add(student4);
      System.out.println("Created by students: " + journal.size());
      removeFailedStudents(journal);
      promoteStudents(journal);
      System.out.println("After operations: " + journal.size() + " students");
      printStudents(journal, 2);
      printStudents(journal, 3);
      printStudents(journal, 4);
    }
    
    public static void removeFailedStudents(List<Student> journal) {
        Iterator<Student> iterator = journal.iterator();
        
        while (iterator.hasNext()) {
            Student student = iterator.next();
            double average = student.calculateAverage();
            
            if (average < 3.0) {
                iterator.remove();
                System.out.println("Delete student: " + student.getName() + " with average " + average);
            }
        }
    }
    public static void promoteStudents(List<Student> journal) {
    for (Student student : journal) {
        if (student.calculateAverage() >= 3.0) {
            int newCourse = student.getCourse() + 1;
            student.setCourse(newCourse);
            System.out.println(student.getName() + " promoted to course " + newCourse);
        }
    }
}
  public static void printStudents(List<Student> journal, int course) {
        System.out.println("\nStudents of course " + course + ":");
        boolean found = false;
        for (Student student : journal) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName() + " (average: " + student.calculateAverage() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found for course " + course);
        }
    }
}
// Задание 2.
import java.util.*;
class PhoneBook {
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

public class Main {
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

      
  
    
