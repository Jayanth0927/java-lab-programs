package SEE;

import CIE.Student;

public class External extends Student {
    private int[] externalMarks;

    // Constructor to initialize external marks and student details
    public External(String usn, String name, int sem, int[] externalMarks) {
        super(usn, name, sem);  // Calling the parent constructor
        this.externalMarks = externalMarks;
    }

    // Method to calculate the total external marks
    public int calculateExternalTotal() {
        int total = 0;
        for (int i = 0; i < externalMarks.length; i++) {
            total += externalMarks[i];
        }
        return total;
    }

    // Get the external marks array
    public int[] getExternalMarks() {
        return externalMarks;
    }
}
