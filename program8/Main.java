class DisplayMessage1 extends Thread {
    public void run() {
        while (true) {
            System.out.println("BMS College of Engineering");
            try {
                Thread.sleep(10000); // Sleep for 10 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class DisplayMessage2 extends Thread {
    public void run() {
        while (true) {
            System.out.println("CSE");
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create thread instances
        DisplayMessage1 thread1 = new DisplayMessage1();
        DisplayMessage2 thread2 = new DisplayMessage2();

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
