import java.util.Scanner;

class Student {
    public String usn;
    public String name;
    public int[] credits;
    public int[] marks;

    public Student(int n) {
        credits = new int[n];
        marks = new int[n];
    }

    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USN: ");
        usn = scanner.nextLine();
        System.out.println("Enter Name: ");
        name = scanner.nextLine();

        for (int i = 0; i < credits.length; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    public double calculateSGPA() {
        double totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < credits.length; i++) {
            int gradePoint = convertMarksToGradePoints(marks[i]);
            totalPoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }

    private int convertMarksToGradePoints(int marks) { 
        if (marks >= 90) return 10;
        if (marks >= 80) return 9;
        if (marks >= 70) return 8;
        if (marks >= 60) return 7;
        if (marks >= 50) return 6;
        if (marks >= 40) return 5;
        return 0;
    }

    public void displayDetails() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        
        System.out.println("Subjects Details:");
        for (int i = 0; i < credits.length; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }

        double sgpa = calculateSGPA();
        System.out.printf("SGPA: %.2f\n", sgpa);
    }
}
