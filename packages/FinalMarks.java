import CIE.Internals;
import SEE.External;

public class FinalMarks {
    public static void main(String[] args) {
        int[] internalMarks1 = {20, 30, 40, 35, 25};
        int[] externalMarks1 = {60, 70, 75, 80, 65};

        int[] internalMarks2 = {22, 33, 45, 50, 40};
        int[] externalMarks2 = {65, 68, 78, 72, 85};

        int[] internalMarks3 = {19, 25, 38, 33, 28};
        int[] externalMarks3 = {58, 65, 70, 80, 60};

        Internals[] internalsStudents = new Internals[3];
        External[] externalStudents = new External[3];

        internalsStudents[0] = new Internals("1BM23CS001", "JD", 5, internalMarks1);
        externalStudents[0] = new External("1BM23CS001", "JD", 5, externalMarks1);

        internalsStudents[1] = new Internals("1BM23CS002", "JS", 5, internalMarks2);
        externalStudents[1] = new External("1BM23CS002", "JS", 5, externalMarks2);

        internalsStudents[2] = new Internals("1BM23CS003", "AM", 5, internalMarks3);
        externalStudents[2] = new External("1BM23CS003", "AM", 5, externalMarks3);

        for (int i = 0; i < 3; i++) {
            displayFinalMarks(internalsStudents[i], externalStudents[i]);
        }
    }

    public static void displayFinalMarks(Internals internals, External external) {
        int internalTotal = internals.calculateInternalTotal();
        int externalTotal = external.calculateExternalTotal();
        int finalTotal = internalTotal + externalTotal;

        System.out.println("Student: " + internals.getName());
        System.out.println("USN: " + internals.getUsn());
        System.out.println("Semester: " + internals.getSem());
        System.out.println("Internal Marks Total: " + internalTotal);
        System.out.println("External Marks Total: " + externalTotal);
        System.out.println("Final Marks (Internal + External): " + finalTotal);
        System.out.println();
    }
}
