import java.util.*;

public class StudentProcessor {
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
