import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Set the number of subjects to 8
        int numberOfSubjects = 8;
        
        Student student = new Student(numberOfSubjects);
        
        student.acceptDetails();
        student.displayDetails();
        
        scanner.close();
    }
}
