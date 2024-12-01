class Q {
    int n;
    boolean valueSet = false; // Flag to check if value is set

    synchronized int get() {
        // Wait until a value is set by the producer
        while (!valueSet) {
            try {
                wait(); // Wait until a value is put
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Got: " + n);
        valueSet = false; // Reset the flag
        notify(); // Notify the producer that value is consumed
        return n;
    }

    synchronized void put(int n) {
        // Wait until the consumer has consumed the previous value
        while (valueSet) {
            try {
                wait(); // Wait until consumer gets the value
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.n = n;
        System.out.println("Put: " + n);
        valueSet = true; // Set the flag indicating value is set
        notify(); // Notify the consumer that a new value is available
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (i < 15) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        int i = 0;
        while (i < 15) {
            q.get(); // Call get() without storing the result
            i++;
        }
    }
}

class PC {
    public static void main(String args[]) {
        Q q = new Q();

        new Producer(q);
        new Consumer(q);

        System.out.println("Press Control-C to stop.");
    }
}
