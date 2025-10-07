import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student("Ben", "211", 1, Arrays.asList(4,5,3,4));
        Student student2 = new Student("Tom", "200", 3, Arrays.asList(3,5,4,3));
        Student student3 = new Student("Harry", "205", 2, Arrays.asList(4,4,4,3));
        Student student4 = new Student("Jack", "100", 1, Arrays.asList(2,2,2,2));        
      
        List<Student> journal = new ArrayList<>();
        journal.add(student1);
        journal.add(student2);
        journal.add(student3);
        journal.add(student4);
        
        System.out.println("Created students: " + journal.size());
        StudentProcessor.removeFailedStudents(journal);
        StudentProcessor.promoteStudents(journal);
        System.out.println("After operations: " + journal.size() + " students");
        StudentProcessor.printStudents(journal, 2);
        StudentProcessor.printStudents(journal, 3);
        StudentProcessor.printStudents(journal, 4);
    }
}
      
  
    
