package CIE;

public class Internals extends Student {
    private int[] internalMarks;

    // Constructor to initialize internal marks and student details
    public Internals(String usn, String name, int sem, int[] internalMarks) {
        super(usn, name, sem);  // Calling the parent constructor
        this.internalMarks = internalMarks;
    }

    // Method to calculate the total internal marks
    public int calculateInternalTotal() {
        int total = 0;
        for (int i = 0; i < internalMarks.length; i++) {
            total += internalMarks[i];
        }
        return total;
    }

    // Get the internal marks array
    public int[] getInternalMarks() {
        return internalMarks;
    }
}
